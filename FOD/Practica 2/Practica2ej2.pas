program Practica2ej2;
type

prod = record
	cod: string [10];
	nombre: string [30];
	precio: real;
	stockActual:integer;
	stockMin: integer;
end;

venta = record
	cod: string [10];
	cant: integer;
end;


master = file of prod;
detalle = file of venta;
menStock = file of prod;

procedure leer (var det:detalle; var vent: venta);
begin
	if (not(EOF(det)))begin
		read (det, vent);
	end
	else
		vent.cod:= 9999;
end;

procedure actualizarMaestro (var mas:master; var det:detalle);
var
	totVentas: integer;
	codActual: string[10];
	regiM: prod;
	regiD: venta;
begin
	leer (det, regiD);
	while (regiD.cod <> 9999) do begin
		read (mas,regiM);
		while (regiM.cod <> regiD.cod) do begin
			read (mas, regiM);
		end;
		codActual:= regiD.cod;
		totVentas:=0;
		while (codActual = regiD.cod) do begin
			totVentas:= totVentas + regiD.cant;
			leer (det, regiD);
		end;
		regiM.stockActual:= regiM.stockActual - totVentas;
		seek (mas, filepos(mas) -1);
		write (mas, regiM);
	end;
end;


procedure hacerArchivo (var mas: master; var menorStock: menStock);
var
	i: prod;
begin
	while (not(EOF(mas))) do begin
		read (mas, i);
		if (i.stockActual < i.stockMin) then begin
			write (menorStock, i);
		end;
	end;
end;

var
	mas : master;
	det : detalle;
	op: integer;
	menorStock: menStock;
begin
	assign (mas, 'arch_maestro');
	assign (det, 'arch_detalle');
	assign (menorStock, 'stock_minimo.txt');
	writeln ('Ingrese la opcion a realizar');
	readln (op);
	while (op <> 3) do begin
		if (op = 1) then begin
			reset (mas);
			reset (det);
			actualizarMaestro (mas, det);
			close (mas);
			close (det);
		end;
		if (op = 2) then begin
			reset (mas);
			rewrite (menorStock);
			hacerArchivo (mas, menorStock);
			close (mas);
			close (menorStock);
		end;
		if (op <=0) or (op > 3) then begin
			writeln ('Numero de opcion invalido, cerrando programa');
			op:=3;
		end;
	end;
end.










