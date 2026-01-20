program Parcial_General_3;
Const
	VA = 9999;
	DF = 25;
type
venta = record
	nTicket: integer;
	cod: integer;
	cantVendida: integer;
end;

producto = record
	cod: integer;
	des: string [50];
	stockAct: integer;
	stockMin: integer;
	precio: real;
end;

maestro = file of producto;
detalle = file of venta;

dets = array [1..DF] of detalle;
reg_dets = array [1..DF] of venta;


procedure leer (var deta: detalle; v:venta);
begin
	if (not(EOF(deta))) then begin
		read (deta, v);
	end
	else
		v.cod:=VA;
end;

procedure minimo (var detalles: dets; var regDet: reg_dets; var min: venta);
var
	i: integer;
	pos: integer;
begin
	min.cod:=VA;
	for i:= 1 to DF do begin
		if (min.cod > regDet[i].cod) then begin
			min:= regDet[i];
			pos:=i;
		end;
	end;
	if (min.cod <> VA) then begin
		leer (detalles[pos], regDet[pos]);
	end;
end;
		

procedure actualizar (var mae: maestro; var detalles: dets);
var
	regDet: reg_dets;
	regMae: producto;
	cantTotalVendida: integer;
	montoVendido: real; montoTotalVendido: real;
	i: integer;
	min: venta;
begin
	reset (mae);
	montoTotalVendido:= 0;
	for i:= 1 to DF do begin
		reset (detalles[i]);
		leer (detalles[i], regDet[i]);
	end;
	minimo (detalles, regDet, min);
	while (min.cod <> VA) do begin
		read (mae, regMae);
		while (min.cod <> regMae.cod) do begin
			read (mae, regMae);
		end;
		cantTotalVendida:=0;
		montoVendido:=0;
		while (min.cod = regMae.cod) do begin	
			cantTotalVendida:= cantTotalVendida + min.cantVendida;
			
			minimo (detalles, regDet, min);
		end;
		montoVendido:= regMae.precio * cantTotalVendida;
		if (cantTotalVendida > regMae.stockAct) then begin
			writeln ('No se pudo satisfacer la venta total');
			regMae.stockAct:= 0;
		end
		else begin
			regMae.stockAct:= regMae.stockAct - cantTotalVendida;
		end;
		if (regMae.stockAct < regMae.stockMin) then begin
			writeln ('El producto con codigo ', regMae.cod, ' tiene menos unidades que las minimas')
		end;
		writeln ('Producto: ', regMae.des, '. Monto Vendido del producto ', montoVendido);
		montoTotalVendido:= montoTotalVendido + montoVendido;
		seek (mae, filepos(mae) -1);
		write (mae, regMae);
	end;
	writeln ('Monto Total Vendido: ', montoTotalVendido);
	close (mae);
	for i:=1 to DF do begin
		close (detalles[i]);
	end;
end;
		
			
begin
	actualizar(mae, dettales);
end.


