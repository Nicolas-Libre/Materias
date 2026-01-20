program Practica2ej1;
type
empleado = record
cod: integer;
nombre: string [30];
montoCom: real;
end;

archivo_datos = file of empleado;

procedure leer (var arch: archivo_datos; var emp: empleado);
begin
	if (not (EOF (arch))) then
		read (arch, emp)
	else
		emp.cod := 9999;
end;

var
	arch_datos: archivo_datos;
	arch_compacto: archivo_datos;
	valor_alto: integer;
	reg_actual: empleado; 
	regAEscribir: empleado;
begin
	valor_alto:=9999;
	assign(arch_datos, 'arch_datos');
	assign (arch_compacto, 'arch_comapcto');
	reset (arch_datos);
	
	leer (arch_datos, reg_actual);
	while (reg_actual.cod <> valor_alto) do begin
		writeln ('Empleado N°: ', reg_actual.cod);
		regAEscribir.cod:= reg_actual.cod;
		regAEscribir.nombre:= reg_actual.nombre;
		regAEscribir.montoCom:=0;
		while (regAEscribir.cod = reg_actual.cod) do begin
			regAEscribir.montoCom:= regAEscribir.montoCom + reg_actual.montoCom;
			leer (arch_datos, reg_actual);
		end;
		writeln ('Monto de todas las comisiones: ', regAEscribir.montoCom);
		write (arch_compacto, regAEscribir);
	end;
	
end.
	
	






