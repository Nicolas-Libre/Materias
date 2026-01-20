program Parcial_2;
Const
valorFin = -1;
Type
dato = record
	codMuni:integer;
	posi:integer;
end;
info = record
	dato: dato;
	nomMuni: string [50];
end;



maestro = file of info;
detalle = file of dato;
arc_det = array [1..30] of detalle;
reg_det = array [1..30] of dato;


procedure leer (var det: detalle; var dato: dato);
begin
	if (not (EOF(det))) then begin
		read (det, dato);
	end
	else
		dato.codMuni:=valorFin;
end;

procedure minimo (var min: dato; var reg_deta: reg_det; var arc_deta: arc_det);
var
	i:integer;
begin
	for i:=1 to 30 do begin
		if (reg_deta[i].codMuni < min.codMuni) then begin
			min:= reg_deta[i];
		end;
		leer (arc_deta[i], reg_det[i]);
	end;
end;


var
	i:integer;
	regiM:info;
	mae: maestro;
	regiDet: dato;
	deta: arc_det;
	regiDeta: reg_det;
	min:dato;
	nom: string;
begin
	for i:= 1 to 30 do begin
		writeln ('Ingrese el nombre del archivo detalle existente');
		readln (nom);
		assign (deta[i], nom);
		reset (deta[i]);
		leer (deta[i], regiDeta[i]);
	end;
	writeln ('Ingrese el nombre del archivo maestro existente');
	readln (nom);
	assign (mae, nom);
	reset (mae);
	minimo (min, regiDeta, deta);
	while (min.codMuni <> valorFin) do begin
		regiM.dato.codMuni := min.codMuni;
		while (regiM.dato.codMuni = min.codMuni) do begin
			regiM.dato.posi := regiM.dato.posi + min.posi;
			minimo (min, regiDeta, deta);
		end;
		if (regiM.dato.posi > 15) then begin
			writeln ('El codigo y nombre del municipio a continuacion tiene mas de 15 casos positivos', regiM.dato.codMuni, regiM.nomMuni);
		end;
	end;
		
end.







