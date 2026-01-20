program Practica2ej7;
Const
	valor_alto=9999;
type
rangoNota = 1..10;

alumno = record
	cod: integer;
	apellido: string [30];
	nombre: string [30];
	curs_A: integer;
	final_A: integer;
end;


aux_alumno = record
	cod_alum: integer;
	cod_mat:integer;
end;

cursada = record
	alum: aux_alumno;
	anio: integer;
	aprobada: boolean;
end;

finale= record
	alum: aux_alumno;
	fecha: string[60];
	nota: rangoNota;
end;



	
maestro = file of alumno;
det_Curs = file of cursada; 
det_Final = file of finale;

procedure leerCursada (var det1: det_Curs; var regiD1: cursada);
begin
	if (not(EOF(det1))) then begin
		read (det1, regiD1);
	end
	else
		regiD1.alum.cod_alum:= valor_alto;
end;

procedure leerFinal (var det2: det_Final; var regiD2: finale);
begin
	if(not(EOF(det2))) then begin
		read (det2, regiD2);
	end
	else
		regiD2.alum.cod_alum:=valor_alto;
end;
	
procedure minimo (var regiD1: cursada; var det1: det_Curs; var regiD2:finale; var det2: det_Final; var minTodo: aux_alumno; var minCurs: cursada; var minFinal: finale);
begin
	if (regiD1.alum.cod_alum > regiD2.alum.cod_alum) and (regiD1.alum.cod_mat > regiD2.alum.cod_mat) then begin
		minTodo:= regiD1.alum;
		minCurs:= regiD1;
		leerCursada (det1, regiD1);
	end
	else if (regiD2.alum.cod_alum <= regiD1.alum.cod_alum) and (regiD2.alum.cod_mat <= regiD1.alum.cod_mat) then begin
		minTodo:= regiD2.alum;
		minFinal:= regiD2;
		leerFinal (det2, regiD2);
	end;
end;
var
	mas: maestro;
	regiM: alumno;
	det1: det_Curs;
	regiD1: cursada;
	det2: det_Final;
	regiD2: finale;
	minTodo: aux_alumno;
	minCurs: Cursada;
	minFinal: finale;
begin
	assign (mas, 'arch maestro');
	assign (det1, 'arch cursadas');
	assign (det2, 'arch finales');
	reset (mas);
	reset (det1);
	reset (det2);
	minimo (regiD1,det1,regiD2,det2, minTodo, minCurs, minFinal);
	while (minTodo.cod_alum <> valor_alto) do begin
		read (mas, regiM);
		while (regiM.cod <> minTodo.cod_alum) do begin
			read(mas, regiM);
		end;
		while (regiM.cod = minTodo.cod_alum) do begin
			if (minCurs.aprobada = true) then begin
				regiM.curs_A:= regiM.curs_A +1;
			end;
			if (minFinal.nota >= 4) then begin
				regiM.final_A:= regiM.final_A +1;
			end;
			minimo (regiD1, det1, regiD2, det2, minTodo, minCurs, minFinal);
		end;
		seek (mas, filePos(mas) -1);
		write (mas, regiM);
	end;
end.
		






