program Parcial_rendido;
Const
	VA = 9999;
Type
	presentacion = record
		cod: integer;
		nom: string [30];
		anio: integer;
		codEvento: integer;
		nomEvento: string [30];
		likes: integer;
		dislikes: integeR;
		puntaje: integer;
	end;
// orden: anio -- codEvento -- cod

archivo = file of presentacion;

procedure leer (var a: archivo; var p:presentacion);
begin
	if (not(EOF(a))) then begin
		read (a,p);
	end
	else p.anio:= VA;
end;


procedure actualizarMenosInfluyente (var nomMin: string; var puntajeMin: integer; var DSLMax: integer;  nom: string; puntos: integer; dsl: integer);
begin
	if ((puntos < puntajeMin) or ((puntos = puntajeMin) and (dsl > DSLMax))) then begin
		puntajeMin := puntos;
		DSLMax:= dsl;
		nomMin:=nom;
	end;
end;

procedure corte_de_control( var a: archivo);
var
	p: presentacion;
	anioAct, codEventoAct, codArtistaAct: integer;
	nomEventoAct, nomArtistaAct: string;
	totLikes, totDislikes, dif, totPuntaje, totPresAnio: integer;
	cantAnios: integer;
	nomMin: string;
	puntajeMin, DSLMax: integer;
	presTotal: integer;
begin
	reset (a);
	cantAnios:=0;
	presTotal:=0;
	leer (a, p);
	while (p.anio <> VA) do begin
		anioAct:=p.anio;
		totPresAnio:=0;
		writeln ('Año: ', anioAct);
		while (anioAct = p.anio) do begin
			codEventoAct:= p.codEvento;
			nomEventoAct:= p.nomEvento;
			writeln ('Evento: ', nomEventoAct, ' Codigo: ', codEventoAct);
			puntajeMin:=VA;
			DSLMax:=-1;
			while ((anioAct = p.anio) and (codEventoAct = p.codEvento)) do begin
				totLikes:=0;
				totDislikes:=0;
				totPuntaje:=0;
				codArtistaAct:= p.cod;
				nomArtistaAct:= p.nom;
				writeln ('Artista: ', nomArtistaAct, ' Codigo: ', codArtistaAct);
				while ((anioAct = p.anio) and (codEventoAct = p.codEvento) and (codArtistaAct = p.cod)) do begin
					totLikes:= totLikes + p.likes;
					totDislikes:= totDislikes + p.dislikes;
					totPuntaje:= totPuntaje + p.puntaje;
					totPresAnio:= totPresAnio +1;
					leer (a,p);
				end;
				dif:= totLikes- totDislikes;
				writeln ('Likes Totales: ', totLikes, 'artista: ', codArtistaAct);
				writeln ('Dislikes Totales: ', totDislikes, 'artista: ', codArtistaAct);
				writeln ('Diferencia: ', dif, 'artista: ', codArtistaAct);
				writeln ('Puntaje Total: ', totPuntaje, 'artista: ', codArtistaAct);
				actualizarMenosInfluyente (nomMin, puntajeMin, DSLMax, nomArtistaAct, totPuntaje,totDislikes);
			end;
			writeln ('El artista ', nomMin, 'fue el menos influyente de ', nomEventoAct, ' del año ', anioAct);
		end;
		cantAnios:= cantAnios +1;
		presTotal:= presTotal + totPresAnio;
		writeln ('Durante el año ', anioAct, ' se registraron ', totPresAnio, ' de presentaciones de artistas');
	end;
	writeln ('El promedio total de presentaciones por año es: ', presTotal / cantAnios, 'presentaciones');
	close (a);
end;
				
		

var
	a:archivo;
begin
	assign (a, 'corte de control');
	corte_de_control (a);
end.




