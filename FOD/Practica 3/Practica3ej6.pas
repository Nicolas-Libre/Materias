program practica3ej6;
Const
	valor_alto = 9999;
type
	prenda = record
		cod: integer;
		descripcion: string [60];
		colores: string[30];
		tipo: integer;
		stock: integer;
		precioUni: real;
	end;

archPrendas = file of prenda;
archPrendasFuera = file of integer;

procedure leer (var arch2: archPrendasFuera; var cod: integer);
var
	aux: prenda;
begin
	if (not(EOF(arch2))) then begin
		read (arch2, aux.cod);
		cod:= aux.cod;
	end
	else
		cod:=valor_alto;
end;

procedure eliminarPrendas (var arch: archPrendas; var arch2: archPrendasFuera);
var
	reg1: prenda;
	cod: integer;	
begin
	reset (arch);
	reset (arch2); 
	leer (arch2, cod);
	while (cod <> valor_alto) do begin
		read (arch, reg1);
		while (reg1.cod <> cod) do begin
			read (arch, reg1);
		end;
		reg1.stock:= -1;
		seek (arch, filepos(arch) -1);
		write (arch, reg1);
		leer (arch2, cod);
	end;
	close (arch);
	close (arch2);
end;

procedure crearNuevoMaestro (var nuevoMae: archPrendas; var arch:archPrendas);
var
	pLeida: prenda;
begin
	reset (arch);
	while (not(EOF(arch))) do begin
		read (arch, pLeida);
		if (pLeida.cod <> -1) then begin
			write (nuevoMae, pLeida);
		end;
	end;
	close (arch);
end;

	

var
	arch, nuevoMae: archPrendas;
	arch2: archPrendasFuera;
	
begin
	assign (arch, 'archivo_prendas');
	assign (arch2, 'archivo_prendas_fuera');
	eliminarPrendas (arch, arch2);
	rename (arch, 'archivo_prendas_old');
	assign (nuevoMae, 'archivo_prendas');
	rewrite (nuevoMae);
	crearNuevoMaestro (nuevoMae, arch);
	close (nuevoMae);
end.
	
	

