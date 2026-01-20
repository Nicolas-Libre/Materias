program Parcial_General_2;
type
 tProducto = record
        codigo: integer;
        nombre: string[50];
        presentacion: string[100];
    end;
tArchProductos = file of tProducto;


procedure agregar (var a: tArchProductos; producto:tProducto);
var
	cabe: tProducto;
begin
	reset (a);
	read (a, cabe);
	if (cabe.codigo = 0) then begin
		seek (a, filesize (a));
		write (a, producto);
	end
	else begin
		seek (a, (cabe.codigo * -1));
		read (a, cabe);
		seek (a, filepos(a) -1);
		write (a, producto);
		seek (a,0);
		write (a, cabe);
	end;
	close (a);
end;

function ExisteProducto (var a: tArchProductos; cod: integer) : boolean;
var
	ok: boolean;
	p: tProducto;
begin
	ok:=false;
	reset (a);
	while (not(EOF(a))and (not ok)) do begin
		read (a, p);
		if (p.codigo = cod) then begin
			ok:= true;
		end;
	end;
	close (a);
	ExisteProducto:= ok;
	
end;

procedure eliminar (var a: tArchProductos; producto:tProducto);
var
	cabe: tProducto;
	aux: tProducto;
	existe: boolean;
begin
	existe:= ExisteProducto (a, producto.codigo);
	if (existe) then begin
			reset (a);
			read (a, cabe);
			read (a, aux);
			while (aux.codigo <> producto.codigo) do begin
				read (a,aux);
			end;
			seek (a, filepos(a) -1);
			write (a, cabe);
			aux.codigo := (filepos(a) *-1)-1;
			seek (a,0);
			write (a, aux);
			close (a);
	end;
end;

begin



end.

