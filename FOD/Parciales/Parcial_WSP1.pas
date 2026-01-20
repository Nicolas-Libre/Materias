program Parcial_WSP1;
Const
	DF = 30;
	VA = 9999;
Type
	infoMae = record
		codigo: integer;
		nombre: string [30];
		positivos: integer;
	end;
// ordenado por codigo;
	infoDet = record
		codigo: integer;
		cantPosi: integer;
	end;
// ordenado por codigo;

detalle = file of infoDet;
maestro = file of infoMae;

vec_deta = array [1..DF] of detalle;
vec_regDeta = array [1..DF] of infoDet;

procedure leer (var deta: detalle; var iD: infoDet);
begin
	if (not(EOF(deta))) then begin
		read (deta, iD);
	end
	else iD.codigo:=VA;
end;

procedure minimo (var vecDet: vec_deta; var vecRDeta: vec_regDeta; var min: infoDet);
var
	i:integer;
	pos:integer;
begin
	min.codigo:= VA;
	for i:=1 to DF do begin
		if (vecRDeta[i].codigo < min.codigo) then begin
			min:= vecRDeta[i];
			pos:=i;
		end;
	end;
	if (min.codigo <> VA) then begin
		leer (vecDet[pos], vecRDeta[pos]);
	end;
end;

// se supone que a partir de los archivos detalles,
// el usuario desea acumular los casos positivos, por lo cual se suma a lo que se tiene en el maestro.
// En el caso de que se quiera reemplazar los casos, se tendria que cambiar diversas lineas  (x e y) por lo siguiente
// X: if regMae.positivos > 15 or totPosi > 15 then writeln (codigo municipio y nombre muniipio)
// Y: regMae.positivos:= totPosi ---- seek (mae, filepos(mae) -1); write (mae, regMae);


procedure actualizar_y_informar (var mae:maestro; var vecDeta: vec_deta);
var
	vecRDeta: vec_regDeta;
	regMae: infoMae;
	min: infoDet;
	i: integer;
	totPosi: integer;
begin
	for i:=1 to DF do begin
		reset (vecDeta[i]);
		leer (vecDeta[i], vecRDeta[i]);
	end;
	minimo (vecDeta, vecRDeta, min);
	reset (mae);
	while (min.codigo <> VA) do begin
		read (mae, regMae);
		while (min.codigo <> regMae.codigo) do begin
			read (mae, regMae);
		end;
		totPosi:=0;
		while (min.codigo = regMae.codigo) do begin
			totPosi:= totPosi + min.cantPosi;
			minimo (vecDeta,vecRDeta, min);
		end;
		regMae.positivos:= regMae.positivos + totPosi;
		if (regMae.positivos > 15) then begin
			writeln ('Codigo: ', regMae.codigo, ' nombre: ', regMae.nombre, ' (supero los 15 positivos)');
		end;
		seek (mae, filepos(mae) -1);
		write (mae, regMae);
	end;
	close (mae);
	for i:= 1 to DF do begin
		close (vecDeta[i]);
	end;
end;
		
var
	mae: maestro;
	vecDeta: vec_deta;
	i: integer;
	nombre: string;
begin
	readln (nombre);
	assign (mae, nombre);
	for i:= 1 to DF do begin
		readln (nombre);
		assign (vecDeta[i], nombre);
	end;
	actualizar_y_informar (mae, vecDeta);
end.
