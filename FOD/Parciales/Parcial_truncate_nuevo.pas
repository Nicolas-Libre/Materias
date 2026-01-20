program Parcial_truncate_nuevo;
Const
	VA = 9999;
Type

	prenda = record
		cod_prenda: integer;
		desc: string [50];
		colores: string [30];
		tipo_prenda: string [30];
		stock: integer;
		precioUni: real;
	end;
	
archivo = file of prenda;
bajas = file of integer; // archivo con codigos a eliminar

procedure leer (var a:archivo; var p:prenda);
begin
	if (not(EOF(a))) then begin
		read (a,p);
	end
	else p.stock:= VA;
end;

procedure leerBajas (var b: bajas; var cod: integer);
begin
	if (not(EOF(b))) then begin
		read (a,cod);
	end
	else cod:=VA;
end;


// se supone que el archivo "bajas" solo tiene codigos que si existen
// de no ser asi, se implementaria una funcion Existe producto que lo verifique


procedure marcarEliminados (var a: archivo; var b: bajas);
var
	p:prenda;
	codEli: integer;
begin
	reset (a);
	reset (b);
	leerBajas(b,codEli);
	while (codEli <> VA) do begin
		seek (a,0);
		leer (a, p);
		while (p.cod_prenda <> codEli) do begin
			leer (a,p);
		end;
		seek (a, filepos(a) -1);
		p.stock:= -1;
		write (a, p);
		leerBajas (b,codEli);
	end;
	close (a);
	close (b);
end;


procedure compatacion (var a: archivo);
var
	posUltimo, pos: integer;
	ultimaP, p: prenda;
begin
	pos:=0;
	reset (a);
	posUltimo:= (filesize (a) -1);
	while (pos <= posUltimo) do begin
		seek (a, pos);
		leer (a,p);
		if (p.stock < 0) then begin
			repeat
				seek (a, posUltimo);
				leer (a, ultimaP);
				posUltimo:= posUltimo -1;
			until ((ultimaP.stock >= 0) or (pos > posUltimo));
			if (pos <= posUltimo) then begin
				seek (a, pos);
				write (a, ultimaP);
			end;
		end;
		pos:=pos+1;
	end;
	seek (a, posUltimo +1);
	truncate (a);
	close(a);
end;
		
	
			
	
		
		
		
		
		
		
		
