program P3ejercicio1;
type
socio = record
	numero:integer;
	nombre:string;
	edad:integer;
end;

arbol =^nodo;
nodo =record
	dato:socio;
	HD:arbol;
	HI:arbol;
end;


Vnombres= array [1..5]of string;

procedure CargarVector (var v:Vnombres);
var
i:integer;
n:string;
begin
	for i:= 1 to 5 do begin
		readln (n);
		v[i]:=n;
	end;
end;
procedure SocioAleatorio (var s:socio; v:Vnombres);
var
//num:integer;
//ed:integer;
b:integer;
begin
//num:= random (5);
//ed:= random (100);
b:= random (5) +1;
s.numero := random (50);
s.edad:=random (100);
s.nombre:= v[b];
end;

procedure AgregaralArbol (var a:arbol; s:socio);
begin
	if a=nil then begin
		new (a);
		a^.dato.numero:= s.numero;
		a^.dato.edad:=s.edad;
		a^.dato.nombre:=s.nombre;
		a^.HD:=nil;
		a^.HI:=nil;
	end
	else 
	if (a^.dato.numero <= s.numero) then begin
		AgregaralArbol (a^.HI,s);
		
	end
	else begin
		AgregaralArbol (a^.HD,s);
	end;
		
end;
procedure ImprimirArbol (a:arbol);
begin
	if a <> nil then begin
		imprimirArbol(a^.HD);
		writeln ('se llama ', a^.dato.nombre);
		writeln ('la edad es ',a^.dato.edad);
		writeln ('el numero es ',a^.dato.numero);
		ImprimirArbol(a^.HI);
	end;
end;
procedure RetornarMaximo (a:arbol; var maxedad:integer; maxNsocio:integer);
begin
	if a <> nil then begin
		RetornarMaximo (a^.HI, maxedad,maxNsocio);
		if a^.dato.edad > maxedad then begin
			maxedad:=a^.dato.edad;
			maxNsocio:=a^.dato.numero;
		end;
		RetornarMaximo (a^.HD, maxedad,maxNsocio);
	end;	
end;

var
v:Vnombres;
a:arbol;
s:socio;
maxNsocio:integer;
maxedad:integer;
BEGIN
	randomize;
	cargarVector (v);
	SocioAleatorio (s,v);
	maxedad:=0;
	maxNsocio:=0;
	while s.numero <> 0 do begin
		AgregaralArbol (a,s);
		SocioAleatorio (s,v);
	end;
	ImprimirArbol (a);
	RetornarMaximo (a, maxedad, maxNsocio);
	writeln ('el socio Numero ', maxNsocio); writeln ('tiene la mayator edad con ', maxedad);
END.

