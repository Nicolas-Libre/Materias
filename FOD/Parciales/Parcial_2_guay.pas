program Parcial_2_guay;
Const
	VA= 9999;
Type
	tProducto = record
		cod: integer;
		nombre: string[30];
		presentacion: string [100];
	end;

archivo = file of tProducto;

procedure leerTProducto (var a:archivo; tProd: tProducto);
begin
	if (not(EOF(a))) then begin
		read (a, tProd);
	end
	else tProd.cod:= VA
end;

function ExisteProducto (var a: archivo; cod: integer) : boolean;
var
	tProd: tProducto;
	ok: boolean;
begin
	reset (a);
	ok:= false;
	leerTProducto (a, tProd);
	while ((tProd.cod <> VA) or (ok = false)) do begin
		if (tProd.cod = cod) then begin
			ok:=true;
		end;
	end;
	close (a);
	ExisteProducto:= ok;
end;


procedure agregar (var a:archivo; prod: tProducto);
var
	cabe: tProducto;
begin
	if (not(ExisteProducto (a, prod.cod))) then begin
		reset (a);
		leerTProducto(a, cabe);
		if (cabe.cod = 0) then begin
			seek (a, filesize (a));
			write (a, prod);
		end
		else begin
			seek (a, (cabe.cod*-1));
			leerTProducto(a, cabe);
			seek (a, filepos(a) -1);
			write (a, prod);
			seek (a, 0);
			write (a, cabe);
		end;
		close (a);
	end
	else writeln ('El producto ya existe');
end;

procedure eliminar (var a:archivo; prod: tPRoducto);
var
	cabe: tProducto;
	aux: tProducto;
begin
	if (ExisteProducto(a, prod.cod)) then begin
		reset (a);
		leerTProducto (a, cabe);
		leerTProducto (a, aux);
		while (aux.cod <> prod.cod) do begin
			leerTProducto (a,aux);
		end;
		seek (a, filepos(a) -1);
		write (a, cabe);
		cabe := aux;
		cabe.cod:= ((filepos(a) -1) *-1);
		seek (a, 0);
		write (a, cabe);
		close (a);
	end
	else writeln ('El producto no existe');
end;
		
		

var
	a: archivo;
	prod: tProducto;
begin
	// readln de campos de prod;
	assign (a, 'archivo ');
	agregar (a, prod);
	eliminar (a, prod);
end.
	




