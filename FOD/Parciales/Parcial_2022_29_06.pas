program Parcial_2022_29_06;

Type
	municipio = record
		nom: string [30];
		desc: string [50];
		habitantes: integer;
		metros2: integer;
		anioCreacion: integer;
	end;
	
archivo = file of municipio;
procedure leerParteMunicipio (var m: municipio);
begin
	readln (m.desc);
	readln (m.habitantes);
	readln (m.metros2);
	readln (m.anioCreacion);
end;
function ExisteMunicipio (var a: archivo; nom: string) : boolean;
var
	ok: boolean;
	m: municipio;
begin
	ok:=false;
	reset (a);
	while (not(EOF(a)) and not (ok)) do begin
		read (a,m);
		if (m.nom = nom) then begin
			ok:=true;
		end;
	end;
	close (a);
	ExisteMunicipio:=ok;
end;

procedure AltaMunicipio (var a: archivo);
var
	m:municipio;
	cabe: municipio;
begin
	readln (m.nom);
	if (not(ExisteMunicipio (a, m.nom))) then begin
		leerParteMunicipio (m);
		reset (a);
		read (a, cabe);
		if cabe.habitantes = 0 then begin
			seek (a, filesize(a));
			write (a,m);
		end
		else begin
			seek (a, (cabe.habitantes)*-1);
			read (a, cabe);
			seek (a, filepos(a) -1);
			write (a, m);
			seek (a,0);
			write (a, cabe);
		end;
		close (a);
	end
	else writeln ('El municipio ya existe');
end;

procedure BajaMunicipio (var a: archivo);
var
	n:string[30];
	cabe: municipio;
	m:municipio;
begin
	readln (n);
	if (ExisteMunicipio (a, n)) then begin
		reset (a);
		read (a, cabe);
		read (a,m);
		while (m.nom <> n) do begin
			read (a,m);
		end;
		seek (a, filepos(a) -1);
		write (a, cabe);
		m.habitantes:= ((filepos (a) -1) *-1);
		seek (a,0);
		write (a, m);
		close (a);
	end
	else writeln('El municipio no existe');
end;
	
begin
end.
