program Parcial_3_guay;
Const
	DF= 25;
	VA = 9999;
Type
	venta = record
		ticket: integer;
		codProd: integer;
		cantUni: integer;
	end;

detalle = file of venta;
vec_Deta = array[1..DF] of detalle;
vec_regiDeta = array[1..DF] of venta;
// ordenados por codigo de producto

	producto = record
		cod: integer;
		desc: string[50];
		stockAct: integer;
		stockMin: integer;
		precio: real;
	end;
	
maestro = file of producto;
procedure leer (var det: detalle; var v:venta);
begin	
	if (not(EOF(det))) then begin
		read (det, v);
	end
	else v.codProd:= VA;
end;

procedure minimo (var vDetalle: vec_deta; var vRDeta: vec_regiDeta; var min: venta);
var
	i: integer;
	pos: integer;
begin
	min.codProd:=VA;
	for i:= 1 to DF do begin
		if (vRDeta[i].codProd < min.codProd) then begin
			min:=vRDeta[i];
			pos:=i;
		end;
	end;
	if (min.codProd <> VA) then leer (vDetalle[pos], vRDeta[pos]);
end;

procedure actualizarMaestro (var mae: maestro; var vDetalle: vec_deta);
var
	vRDeta: vec_regiDeta;
	regMae: producto;
	min: venta;
	i: integer;
	cantTotalVendida: integer;
	montoDia, montoTotal: real;
begin
	for i:= 1 to DF do begin
		reset (vDetalle[i]);
		leer (vDetalle[i], vRDeta[i]);
	end;
	reset (mae);
	minimo (vDetalle, vRDeta, min);
	montoTotal:= 0;
	while (min.codProd <> VA) do begin
		read (mae,regMae);
		while (min.codProd <> regMae.cod) do begin
			read (mae,regMae);
		end;
		cantTotalVendida:= 0;
		montoDia:=0;
		while (min.codProd = regMae.cod) do begin
			cantTotalVendida:= cantTotalVendida + min.cantUni;
			minimo (vDetalle, vRDeta, min);
		end;
		montoDia:= cantTotalVendida * regMae.precio;
		montoTotal:= montoTotal + montoDia;
		if (cantTotalVendida = 0) and (regMae.stockAct > 0) then begin
			writeln ('El producto con codigo ', regMae.cod, ' tiene unidades y no se vendio');
		end
		else if (cantTotalVendida > regMae.stockAct) then begin
			regMae.stockAct:= 0;
			writeln ('La venta no se pudo satisfacer (Se pidio mas de lo que se tiene)');
		end
		else begin
			regMae.stockAct:=regMae.stockAct - cantTotalVendida;
		end;
		if (regMae.stockAct < regMae.stockMin) then begin
			writeln ('El producto con codigo ', regMae.cod, ' quedo por debajo del stock minimo');
		end;
		
		writeln ('Producto: ', regMae.cod, ' Monto En el dia Vendido: ', montoDia);
		seek (mae, filepos(mae) -1);
		write (mae, regMae);
	end;
	for i:= 1 to DF do begin
		close (vDetalle[i]);
	end;
	close (mae);
	writeln ('Monto Total Vendido de todos los producto: ', montoTotal);
end;

var
	mae: maestro;
	vDetalle: vec_deta;
	i: integer;
	stringDeI: string;
begin
	assign (mae, 'maestro');
	for i:= 1 to DF do begin
		Str (i, stringDeI);
		assign (vDetalle[i], 'det ' + stringDeI);
	end;
	actualizarMaestro (mae, vDetalle);
end.
		
			




