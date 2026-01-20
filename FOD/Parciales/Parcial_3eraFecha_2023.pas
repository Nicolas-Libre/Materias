program Parcial_3eraFecha_2023;
Const
valorAlto = 99999;
DF = 20;
Type
producto = record
	cod:integer;
	nombre: string [40];
	precio: real;
	stockAct: integer;
	stocMin: integer;
end;

venta = record
	cod: integer;
	cantVendida: integer;
end;

maestro = file of producto;
detalle = file of venta;
arch_deta = array [1..DF] of detalle;
regi_Deta = array [1..DF] of venta;
carga = Text;

procedure leer (var deta: detalle; var v: venta);
begin
	if (not(EOF(deta))) then begin
		read (deta, v);
	end
	else
		v.cod:= valorAlto;
end;

procedure minimo (var detalles: arch_deta; var registros: regi_deta; var min: venta);
var
	i: integer;
	pos: integer;
begin
	min.cod:= valorAlto
	for i:= 1 to DF then begin
		if (registros[i].cod < min.cod) then begin
			min:= registros[i];
			pos:= i;
		end;
	end;
	if (min.cod <> valorAlto) then begin
		leer (detalles[pos], registros[pos]);
	end;
end;

procedure cargarDatos (var mae: maestro; var detalles: arch_deta; var registros: regi_deta; var texto: carga);
var
	regiM: producto;
	min: venta;
	totalMonto: real;
begin
	assign (texto, 'informe.txt');
	rewrite (texto);
	reset (mae);
	read (mae, regiM);
	minimo (detalles, registros, min);
	while (not(EOF(mae))) do begin
		while (min.cod <> regiM.cod) do begin
			read (mae, regiM);
		end;
		totalMonto:=0;
		while (min.cod = regiM.cod) do begin
			regiM.stockAct:= regiM.stockAct - min.cantVendida;
			totalMonto:= totalMonto + (regiM.precio*min.cantVendida);
			minimo (detalles, registros, min);
		end;
		seek (mae, filepos(mae) -1);
		write (mae, regiM);
		with regiM do begin
			writeln (texto,' ',cod,' ',nombre,' ',precio,' ',stockAct,' ',stockMin);
		end;
		if (totalMonto > 10000) then begin
			writeln (texto, ' El producto ', regiM.cod, ' supero los 10000 pesos');
		end;
	end;
	close (mae);
	close (texto);
end;




