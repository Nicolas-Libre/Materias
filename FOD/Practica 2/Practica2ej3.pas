program Practica2ej3;
Const
valor_alto 'ZZZ';
type
dato = record
prov: string [30];
alfa: integer;
encue: integer;
end;

paraDet = record
dato: dato;
loc: integer;
end;

maestro = file of dato;
detalle = file of paraDet;



procedure leer (var det: detalle; var info: paraDet);
begin
	if (not(EOF(det))) then begin
		read (det, info);
	end
	else
		info.dato.prov: = valor_alto;
end;

procedure minimo (var r1, r2: paraDet; var det1, det2: detalle; var min: paraDet);
begin
	if r1.dato.prov < r2.dato.prov then begin
		min:=r1;
		leer (det, r1);
	end;
	else begin
		min:=r2;
		leer (det2,r2);
	end;

end;	

var
	mas: maestro;
	det1: detalle;
	det2: detalle;
	regiD1: paraDet;
	regiD2: paraDet;
	regiM: dato;
	min: paraDet;
begin
	assign (mas, 'maestro');
	assign (det1, 'primer detalle');
	assign (det2, 'segundo detalle');
	reset (mas);
	reset (det1);
	reset (det2);
	leer (det1, regiD1)
	leer (det2, regiD2);
	//Se supone que los detalles estar ordendo por nombre de provincia de manera alfabetica
	minimo (rediD1, regiD2, min);
	while (min.dato.prov <> valor_alto) do begin
		read (mas, regiM);
		while (regiM.prov <> min.dato.prov) do begin
			read (mas, regiM);
		end;
		while (regiM = min.dato.prov) do begin
			regiM.encue:=regiM.encue + min.dato.encue;
			regiM.alfa:= regiM.alfa + min.dato.alfa
			minimo (regiD1, regiD2, det1, det2, min);
		end;
		seek (mas, filepos(mas)-);
		write (mas, regiM);
	end;
		

end.








