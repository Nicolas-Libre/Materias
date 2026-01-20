program Practca2ej5;
Const
valor_alto = 999999;

type
sesion = record;
	cod_usuario: integer;
	fecha: string;
	tiempo: integer;
end;

detalle = file of sesion;
det_arc = array [1..5] of file of detalle;
regis = array [1..5] of sesion;
maestro = file of sesion;


procedure leer (var det:detalle; var info: sesion);
begin
	if (not(EOF(det))) then begin
		read (det, info);
	end
	else
		info.cod_usuario = valor_alto;
end;

procedure buscarMinimo (var regiD: regis; var pos: integer);
var
	i:integer;
	min:integer;
begin
	min:= valor_alto;
	for i:= 1 to 5 do begin
		if regiD[i].cod_usuario < min then begin	
			pos:=i;
			min:= regiD[i].cod_usuario;
		end;
	end;
end;

procedure minimo (var detalles: arc_det; var regiD: regis; var min: sesion);
var
	i: integer;
begin
	buscarMinimo (regiD, i);
	min:= regiD[i];
	leer (det[i], regiD[i]);
end;

var
	mas: maestro;
	regiM: sesion;
	detalles: arc_det;
	regiD: regis;
	i:integer;
	min: sesion;
begin
	assign (mas, 'master');
	rewrite (mas);
	for i:= 1 to 5 do begin
		assign (det[i], 'det' + i);
		reset (det[i]);
		leer (det[i], regiD[i]);
	end;
	minimo (detalles, regiD, min);
	while min.cod_usuario <> valor_alto do begin
		regiM.cod_usuario := min.cod_usuario;
		regiM.tiempo:=0;
		while regiM.cod_usuario = min.cod_usuario do begin
			regiM.fecha:= min.fecha;
			while (regiM.cod_usuario = min.cod_usuario) and (regiM.fecha = min.fecha) do begin
				regiM.tiempo : = regiM.tiempo + min.tiempo;
				minimo (detalles, regiD, min);
			end;
		end;
		write (mas, regiM);
	end;
	close (mas);
	for i:= 1 to 5 do begin
		close (det[i]);
	end;

end.






