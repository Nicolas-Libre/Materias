program Practica2ej4;
Const 
	valor_alto = 9999;
	
type
producto = record
	cod: integer;
	nombre: string[30];
	desc: string [150];
	stockDis: integer;
	stockMin: integer;
end;

paraDet = record
	cod: integer;
	cantVendida: integer;
end;

maestro = file of producto;
detalle = file of paraDet
det_ar = array [1..30] of detalle;
reg_det = array [1..30] of paraDet;
menorMin = file of Text;

procedure leer (var det: detalle; var info: paraDet);
begin
	if (not(EOF(det))) then begin
		read (det, info);
	end
	else
		info.cod:= valor_alto;
end;

procedure buscarMinimo (var registros: reg_det; var pos: integer);
var
	i:integer;
	min: integer;
begin
	min:= 999999;
	for i:=1 to 30 do begin
		if reg_det[i].cod < min then begin 
			min:= reg_det[i].cod;
			pos:=i;
		end;
	end;
end;

procedure leerMaster (var mas: maestro; info: prod);
begin
	if not(EOF(mas))) then begin
		read (mas, info);
	end
	else
		info.cod:=valor_alto;
end;

procedure minimo (var registros: reg_det; var det: det_ar; var min: paraDet);
var
	i:integeR;
begin
	buscarMinimo (registros, i);
	min:= registros[i];
	leer (det[i], registros [i]);
end;

procedure hacerTexto (var mas: maestro; var menoMinimo: menorMin);
var 
	dato: prod;
begin
	leerMaster (mas, dato);
	while dato.cod <> valorAlto do begin
		if dato.stockDis < dato.stockMin) then begin
			writeln (menorMinimo, 'Codigo: ', dato.cod, ' Nombre: ', dato.nombre, ' Descripcion: ', dato.desc, ' Stock disponible: ', dato.stockDis, ' Stock Minimo: ', dato.stockMin);
		end;
		leerMaster (mas,dato);
	end;
end;
	
	

var
	mas: maestro;
	regiM: prod;
	detalles: arc_det;
	registros: reg_det;
	i:integer;
	strI: string;
	min: paraDet;
	deTexto: menorMin;
begin
	for i:= 1 to 30 do begin
		strI:= i;
		assign (detalles[i], 'det ' + strI);
		reset (detalles[i]);
		leer(detalles[i], registros[i]);
	end;
	assign (mas, 'master');
	reset(mas);
	minimo (registros, detalles, min);
	while (min.cod <> valor_alto) do begin
		read (mas, regiM);
		while (regiM.cod = min.cod) do begin
			regiM.stockDis:= regiM.stockDis - min.cantVendidas;
			minimo (registros, detalles, min);
		end;
		seek (mas, filepos (mas) -1);
		write (mas, regiM);
	end;
	close (mas);
	reset (mas);
	assign (deTexto, 'Stock menor minimo');
	rewrite (deTexto);
	hacerTexto (mas, menorMin);
	close (mas);
	close (deTexto);
end.
		
		
		
		
		







