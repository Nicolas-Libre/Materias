program Parcial_2daFecha_2023;
Const
valorFin = -1;

Type

equipo = record;
	cod: integer;
	nombre: string [50];
	anio: integer;
	codTorneo: integer;
	codRival: integer;
	golesFavo: integer;
	golesReci: integer;
	puntos: integer;
end;

torneos = file of equipo;


procedure leerEquipo (var arch: torneos; var e: equipo);
begin
	if (not(EOF(arch))) then begin
		read (arch, e);
	end
	else
		e.cod:= valorFin;
end;

procedure actualizarMax ( puntos: integer; equiAct: equipo; var champ: equipo; var maxPuntos: integer);
begin
	if (puntos > maxPuntos) then begin
		champ:= equiAct;
		maxPuntos:= puntos;
	end;
end;

procedure cargaDatos (var arch: torneos);
var
	champ: equipo;
	maxPuntos: integer;
	e: equipo;
	anioAct: integer;
	torAct: integer;
	codEquiAct: integer;
	cantGanados: integer;
	cantPerdidos: integer;
	cantEmpatados: integer;
	cantTotalPuntos: integer;
	totalGolesAFavor: integer;
	totalGolesEnContra: integer;
	difTotalGoles: integer;
begin
	reset (arch);
	leerEquipo (arch, e);
	
	while (e.cod <> valorFin) do begin
		anioAct:= e.anio;
		writeln ('Anio: ', anioAct);
		while (anioAct = e.anio) do begin
			torAct:= e.codTorneo;
			maxPuntos:=0;
			writeln ('cod_torneo: ', torAct);
			while ((anioAct = e.anio) and (torAct = e.codTorneo)) do begin
				codEquiAct:= e.cod;
				writeln ('cod_equipo: ', codEquiAct);
				cantGanados:=0;
				cantPerdidos:=0;
				cantEmpatados:=0;
				cantTotalPuntos:=0;
				totalGolesAFavor:= 0;
				totalGolesEnContra:=0;
				difTotalGoles:=0;
				while ((anioAct = e.anio) and (torAct = e.codTorneo) 
					and (codEquiAct = e.cod)) do begin
						totalGolesAFavor:= totalGolesAFavor + e.golesFavo;
						totalGolesEnContra:= totalGolesEnContra + e.golesReci;
						difTotalGoles:= difTotalGoles + (e.golesFavo - e.golesReci);
						case e.puntos of
							0: cantPerdidos:= cantPerdidos +1;
							1: begin
								cantEmpatados:= cantEmpatados +1;
								cantTotalPuntos:= cantTotalPuntos +1;
							   end;
							3: begin
								cantGanados:= cantGanados +1;
								cantTotalPuntos:= cantTotalPuntos +3;
   							   end;
   						leerEquipo(arch, e);
   				end;
   				writeln ('cantitdad total de goles a favor: ', totalGolesAFavor);
   				writeln ('cantidad total de goles en contra: ', totalGolesEnContra);
   				writeln ('diferencia de goles', difTotalGoles);
   				writeln ('cantidad de partidos ganados: ', cantGanados);
   				writeln ('cantidad de partidos perdidos: ', cantPerdidos);
   				writeln ('cantidad de partidos empatados: ', cantEmpatados);
   				writeln ('cantidad total de puntos: ', cantTotalPuntos);
   				actualizarMax (cantTotalPuntos, codEquiAct, champ, maxPuntos);
   			end;
   			writeln ('El equipo ', champ.nombre, ' fue campeon del torneo ', torAct, ' del anio ', anioAct);
   		end;
   	end;
   end;
   close (arch);
end;
   						
							
							
						
						
	
	












