program Parcial_1;
Const
valorFin:= 99999
type
prestamo = record
	sucursal: integer;
	dni_emple: integer;
	n_prestamo: integer;
	fecha_oto: string[30]
	monto: real;
end;

arch_prest = file of prestamo;
arch_text: Text;



procedure leer (var arch: arch_prest; var pres: prestamos);
begin
	if (not(EOF(arch))) then begin
		read (arch, pres);
	end
	else
		pres.sucursal:= valorFin
end;


procedure hacerTexto (var prestamos: arch_prest; var texto: arch_text);
var
	sucuActual:integer;
	dniActual:integer;
	fechaActual: string[30]
	totalVEmpresa: integer;
	totalMEmpresa: integer;
	totalVSucursal: integer;
	totalVentas:integer;
	totalMonto: real;
	regPrestamo: prestamo;
begin
	read (prestamos, regPrestamo);
	while (not(EOF(prestamos))) do begin
		totalVSucursal:=0;
		totalMSucursal:=0;
		sucuActual:= regPrestamos.sucursal;
		write (texto, sucuActual);
		while (sucuActual = regPrestamos.sucursal) do begin
			dniActual:= regPrestamos.dni_emple;
			totalVentas:=0;
			totalMonto:=0;
			write (texto, dniActual);
			while (dniActual = regPrestamos.dni_emple) do begin
				fechaActual := obtenerAnio (regPrestamos.fecha_oto);
				write (texto, fechaActual);
				while (fechaActual = obtenerAnio (regPrestamos.fecha_oto) do begin
					totalVentas := totalVentas +1;
					totalMonto:= totalMonto + regPrestamos.monto;
				end;
				write (texto, totalVentas);
				write (texto, totalMonto);
			end;
			write (texto, totalVentas);
			write (texto, totalMonto);
			totalVSucursal:= totalVSucursal + totalVentas;
			totalMSucursal:= totalMSucursal + totalMonto;
		end;
		write (texto, totalVSucursal);
		write (texto, totalMSucursal);
		totalMEmpresa:=totalMEmpresa + totalMSucursal;
		totalVEmpresa:= totalVEmpresa + totalVSucursal;
	end;
	write (texto, totalMEmpresa);
	write (texto, totalVEmpresa);
		 	
end;

var
	prestamos: arch_prest;
	texto: arch_text;
begin
	assign (prestamos, 'archivo prestamos');
	assgin (texto, 'archivo de texto');
	reset (prestamos);
	rewrite (texto);
	hacerTexto (prestamos, texto);
	Close (prestamos);
	Close (texto);
end.







