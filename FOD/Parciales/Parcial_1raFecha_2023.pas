program Parcial_1raFecha_2023;
Const
valorAlto = 99999;
Type
producto = record
	cod: integer;
	nom: string[50];
	desc: string;
	pCompra: real;
	pVenta: real;
	depo: string;
end;

archivo = file of producto;

procedure leer (var arch: archivo; var p: producto);
begin
	if (not(EOF(arch))) then begin
		read (arch, p);
	end
	else
		p.cod:=valorAlto;
end;

procedure AgregarProducto (var arch: archivo);
var
	pNuevo:producto;
	cabe: producto;
begin
	writeln ('Ingrese los datos del prodcuto a agregar');
	readln (pNuevo.cod);
	if (not (existeProducto (arch, pNuevo.cod))) then begin
		readln (pNuevo.nom);
		readln (pNuevo.desc);
		readln (pNuevo.pCompra);
		readln (pNuevo.pVenta);
		readln (pNuevo.depo);
		reset (arch);
		leer (arch, cabe);
		if (cabe.cod = 0) then begin
			seek (arch, (filesize(arch));
			write (arch, pNuevo);
		end
		else begin
			seek (arch, (cabe.cod*-1));
			read (arch, cabe);
			seek (arch, filepos(arch) -1);
			write (arch, pNuevo);
			seek (arch, 0);
			write (arch, cabe);
		end;
		close (arch);
	end
	else begin
		writeln ('El producto ya existe');
	end;
end;

procedure QuitarProducto (Var arch: archivo);
var
	cod: integer;
	prod: producto;
	cabe: producto;
begin
	writeln ('Ingrese el codigo del producto a eliminar');
	readln (cod);
	ok:= false;
	if existeProducto (arch, cod) then begin
		reset (arch);
		leer (arch, cabe);
		leer (arch, prod);
		while (prod.cod <> cod) do begin
			leer (arch, prod);
		end;
		seek (arch, filepos(arch)-1);
		write (arch, cabe);
		cabe.cod:= ((filepos (arch) -1) *-1);
		seek (arch, 0);
		write (arch, cabe);
		close (arch);
	end
	else begin
		writeln ('El producto no existe');
	end;
end;






