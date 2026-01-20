program Parcial_2023_4_7;
Const
	VA = 9999;
Type
	partido = record
		cod: integer;
		nom: string [30];
		anio: integer;
		codTorneo: integer;
		codRival: integer;
		golesFavor: integer;
		golesContra: integer;
		puntos: integer;
	end;

archivo = file of partido;
procedure leer (var a: archivo; var p:partido);
begin
	if (not(EOF(a))) then begin
		read (a,p);
	end
	else
		p.anio:= VA;
end;

//anio - torneo - equipo

procedure actualizar_campeon (var champ: string; var maxPuntos: integer; puntos: integer; equipo: string);
begin
	if (puntos > maxPuntos) then begin
		champ:= equipo;
		maxPuntos:=puntos;
	end;
end;

procedure calcular_res (var cantGano: integer; var cantPerdio: integer; var cantEmpato: integer; puntos: integer);
begin
	if (puntos = 0) then begin
		cantPerdio:=cantPerdio +1;
	end
	else if (puntos = 1) then begin
		cantEmpato:=cantEmpato +1;
	end
	else cantGano:= cantGano +1;
end;

procedure corte_de_control (var a:archivo);
var
	p:partido;
	totGolesFavor, totGolesContra, dif, cantGanados, cantPerdidos, cantEmpatados, cantPuntos: integer;
	anioAct, torneoAct, codEquipoAct: integer;
	equipoAct: string;
	champ: string;
	maxPuntos: integer;
begin
	reset (a);
	leer (a,p);
	while (p.anio <> VA) do begin
		anioAct:=p.anio;
		writeln ('Año: ', anioAct);
		while (anioAct = p.anio) do begin
			torneoAct:= p.codTorneo;
			writeln ('Codigo del torneo: ', torneoAct);
			maxPuntos:=0;
			champ:='';
			while ((anioAct = p.anio) and (torneoAct = p.codTorneo)) do begin
				totGolesFavor:=0;
				totGolesContra:=0;
				dif:=0;
				cantGanados:=0;
				cantPerdidos:=0;
				cantEmpatados:=0;
				cantPuntos:=0;
				equipoAct:= p.nom;
				codEquipoAct:= p.cod;
				writeln ('Codigo equipo: ', codEquipoAct, ' nombre: ', equipoAct); 
				while ((anioAct = p.anio) and (torneoAct = p.codTorneo) and (equipoAct = p.nom)) do begin
					totGolesFavor:=totGolesFavor + p.golesFavor;
					totGolesContra:= totGolesContra + p.golesContra;
					calcular_res(cantGanados, cantPerdidos, cantEmpatados, p.puntos);
					cantPuntos:=cantPuntos + p.puntos;
					leer(a,p);
				end;
				dif:= totGolesFavor - totGolesContra;
				writeln ('Cantidad total de goles a favor de ', equipoAct, ': ', totGolesFavor);
				writeln ('Cantidad total de goles en contra de ', equipoAct, ': ', totGolesContra);
				writeln ('Diferencia de gol del equipo ', equipoAct, ': ', dif);
				writeln ('Cantidad de partidos ganados de ', equipoAct, ': ', cantGanados);
				writeln ('Cantidad de partidos perdidos de ', equipoAct, ': ', cantPerdidos);
				writeln ('Cantidad de partidos empatados de ', equipoAct, ': ', cantEmpatados);
				writeln ('Cantidad total de puntos de ', equipoAct, ': ', cantPuntos);
				actualizar_campeon (champ,maxPuntos,cantPuntos,equipoAct);
			end;
			writeln ('El equipo llamado ', champ, ' fue campeon del torneo ', torneoAct, ' del año ', anioAct);
		end;
	end;
	close (a);
end;

var
	a:archivo;
begin
	assign (a, 'archivo de torneos por año');
	corte_de_control(a);
end.
