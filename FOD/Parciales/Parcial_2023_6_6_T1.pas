program Parcial_2023_6_6_T1;
Type
	producto = record
		cod: integer;
		nom: string[30];
		desc: string [50];
		compra: real;
		venta: real;
		ubi: string[30];
	end;
archivo = file of producto;

//function ExisteProducto (var a: archivo; var cod: integer) : boolean;



procedure AgregarProducto (var a:archivo);
var
	p:producto;
	cabe: producto;
begin
	readln (p.cod);
	if (not(ExisteProducto (a, p.cod))) then begin
		readln (p.nom);
		readln (p.desc);
		readln (p.compra);
		readln (p.venta);
		readln (p.ubi);
		reset (a);
		read (a, cabe);
		if (cabe.cod = 0) then begin
			seek (a, filesize (a));
			write (a, p);
		end
		else begin
			seek (a, (cabe.cod *-1));
			read (a, cabe);
			seek (a, filepos(a) -1);
			write (a, p);
			seek (a, 0);
			write (a, cabe);
		end;
		close (a);
	end
	else writeln ('El producto ya existe');
end;


procedure QuitarProducto (var a: archivo);
var
	codEli: integer;
	p: producto;
	cabe: producto;
begin
	readln (codEli);
	if (ExisteProducto(a,codEli)) then begin
		reset (a);
		read (a, cabe);
		read (a, p);
		while (p.cod <> codEli) do begin
			read (a,p);
		end;
		seek (a, filepos(a) -1);
		write (a, cabe);
		cabe.cod:= ((filepos(a) -1) *-1);
		seek (a, 0);
		write (a,cabe);
		close(a);
	end
	else writeln ('El producto no existe');
end;
			
			
			
var
	a:archivo;
begin
	assign (a, 'lista inver');
	AgregarProducto (a);
	QuitarProducto (a);
end.
