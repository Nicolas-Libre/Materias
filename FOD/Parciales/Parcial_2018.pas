program Parcial_2018;
Const
	VA = 9999;
type
	info= record
		anio: integer;
		mes: integer;
		dia: integer;
		idUsuario: string[30];
		tiempo: real;
	end;
	
archivo = file of info;	

procedure leer (var arch: archivo; i :info);
begin
	if (not(EOF(arch))) then begin
		read (arch, i);
	end
	else
		i.anio:= VA;
end;

function BuscarAnio (var a: archivo; anio: integer) : boolean;
var
	ok: boolean;
	inf: info;
begin
	ok:=false;
	leer (a, inf);
	while (inf.anio < anio)do begin
		leer (a, inf);
	end;
	if (inf.anio = anio) then begin
			ok:= true;
		end;
	BuscarAnio:= ok;
end;
	

procedure corte_de_control (var a: archivo; anio: integer);
var
	tUsu, tDia, tMes, tAnio: real;
	inf: info;
	existe: boolean;
	mesAct, diaAct: integer;
	usuAct: string;
begin
	reset (a);
	existe:= BuscarAnio(a, anio);
	if (existe) then begin
		seek (a, filepos(a) -1);
		leer (a, inf);
		tAnio:=0;
		writeln ('Anio: ', anio);
		while ((inf.anio <> VA) and (inf.anio = anio)) do begin
			tMes:=0;
			mesAct:= inf.mes;
			writeln ('Mes: ', mesAct);
			while ((inf.anio = anio) and (inf.mes = mesAct)) do begin
				tDia:= 0;
				diaAct:= inf.dia;
				writeln ('Dia: ', diaAct);
				while ((inf.anio = anio) and (inf.mes = mesAct) and (inf.dia = diaAct)) do begin
					tUsu:=0;
					usuAct:= inf.idUsuario;
					while ((inf.anio = anio) and (inf.mes = mesAct) and (inf.dia = diaAct) and (usuAct = inf.idUsuario)) do begin
						tUsu:= tUsu + inf.tiempo;
						leer (a,inf);
					end;
					writeln ('idUsuario: ', usuAct, 'Tiempo total de acceso en el dia ', diaAct,' mes ', mesAct, ' ', tUsu);
					tDia:= tDia + tUsu;
				end;
				writeln ('Tiempo total de acceso en el dia ', diaAct,' mes ', mesAct, ' ', tDia);
				tMes:= tMes + tDia;
			end;
			writeln ('Tiempo total de acceso en el mes ', mesAct, ' ', tMes);
			tAnio:= tAnio + tMes;
		end;
		writeln ('Tiempo total de acceso en el anio ', anio, ' ', tAnio);
	end
	else begin
		writeln ('El anio no se encuentra en el archivo');
	end;
	close (a);
end;

var
	anio: integer;
	a: archivo;
begin
	writeln ('Ingrese el anio a procesar');
	readln (anio);
	corte_de_control (a, anio);
end.
			
			
	
			
	





