program Parcial_General_6;
Const
	DF = 30;
	VA = 9999;
Type
	resumen = record
		cod:integer;
		nombre: string[30];
		fecha: integer;
		cantVendida: integer;
		formaPago: string;
	end;

ventas = file of resumen;
vec_Ventas= array [1..DF] of ventas;
vec_regVentas= array [1..DF] of resumen;

procedure leer (var det: ventas; r:resumen);
begin
	if (not(EOF(det))) then begin
		read (det, r);
	end
	else
		r.fecha:= VA;
end;

procedure minimo (var detalles: vec_Ventas; var infoDetalles: vec_regVentas; min: resumen);
var
	i: integer;
	pos: integer;
begin
	min.fecha:= VA;
	for i:= 1 to DF do begin	
		if (infoDetalles[i].fecha < min.fecha) then begin
			pos:= i;
			min:= infoDetalles[i];
		end;
	end;
	if (min.fecha <> VA) then begin
		leer (detalles[pos], infoDetalles[pos]);
	end;
end;

procedure actualizarMax (var max: string; var cantMax: integer; nom: string; cant: integer);
begin
	if (cant > cantMax) then begin
		max:= nom;
		cantMax:= cant;
	end;
end;

procedure parcial (var detalles: vec_Ventas; var informe: text);
var
	cantMax: integer;
	max: string;
	i: integer;
	infoDetalles: vec_regVentas;
	min: resumen;
	codAct: integer;
	nomAct: string;
	fechaAct: integer;
	cantVendida: integer;
begin
	cantMax:= -1;
	rewrite (informe);
	for i:= 1 to DF do begin
		reset (detalles[i]);
		leer (detalles[i], infoDetalles[i]);
	end;
	minimo (detalles, infoDetalles, min);
	while (min.fecha <> VA) do begin
		codAct:= min.cod;
		nomAct:= min.nombre;
		fechaAct:= min.fecha;
		while (fechaAct = min.fecha) do begin
			writeln (informe, 'Fecha: ', fechaAct);
			cantVendida:= 0;
			while ((codAct = min.cod) and (fechaAct = min.fecha)) do begin
				cantVendida:= cantVendida + min.cantVendida;
				minimo (detalles, infoDetalles, min);
			end;
			writeln (informe, 'El farmaco llamado ', nomAct, ' con codigo ', codAct, ', se vendio un total de ', cantVendida, ' veces');
		end;
		actualizarMax (max, cantMax, nomAct, cantVendida);
	end;
	writeln ('El producto llamado ', max, ' fue el mas vendido con ', cantMax, ' unidades');
	for i:= 1 to DF do begin
		close (detalles[i]);
	end;
	close (informe);
end;
		
begin
end.
