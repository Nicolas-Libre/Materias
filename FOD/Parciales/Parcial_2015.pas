program Parcial_2015;
Const
	VA = 9999;
Type
	producto = record
		cod: integer;
		nom:string [30];
		desc: string [50];
		codBarras: integer;
		cate: string [30];
		stockAct: integer;
		stockMin: integer;
	end;
	pedido = record
		cod: integer;
		cantPedida: integer;
		desc: string [30];
	end;
	
	
detalle = file of pedido;
maestro = file of producto;


procedure leer (var det: detalle; var pe: pedido);
begin
	if (not(EOF(det))) then begin
		read (det, pe);
	end
	else 
		pe.cod:= VA;
end;


procedure minimo (var det1,det2,det3: detalle; var regD1, regD2, regD3: pedido; var min: pedido);
begin
	if ((regD1.cod < regD2.cod) and (regD1.cod < regD3.cod)) then begin
		min:=regD1;
		leer (det1, regD1);
	end
	else if (regD2.cod < regD3.cod) then begin
		min:= regD2;
		leer (det2, regD2);
	end
	else begin
		min:= regD3;
		leer (det3, regD3);
	end;
end;

procedure actualizar (var mae: maestro; var det1,det2,det3: detalle);
var
	regMae: producto;
	regD1,regD2,regD3,min: pedido;
	cantTotalPedida: integer;
begin
	reset(mae);
	reset(det1);
	reset(det2);
	reset(det3);
	leer (det1, regD1);
	leer (det2, regD2);
	leer (det3, regD3);
	minimo (det1,det2,det3, regD1,regD2,regD3, min);
	while (min.cod <> VA) do begin
		read (mae, regMae);
		while (regMae.cod <> min.cod) do begin
			read (mae, regMae);
		end;
		cantTotalPedida:= 0;
		while (regMae.cod = min. cod) do begin
			cantTotalPedida:= cantTotalPedida + min.cantPedida;
			minimo (det1,det2,det3, regD2,regD2,regD3, min);
		end;
		if (regMae.stockAct < cantTotalPedida) then begin
			writeln ('No se pudo satisfacer el pedido. Diferencia: ', cantTotalPedida - regMae.stockAct);
			regMae.stockAct:=0;
		end
		else begin
			regMae.stockAct:= regMae.stockAct - cantTotalPedida;
		end;
		if (regMae.stockAct < regMae.stockMin) then begin
			writeln ('El producto con codigo ', regMae.cod, ' quedo por debajo del stock minimo. Pertenece a la categoria: ', regMae.cate);
		end;
		seek (mae, filePos(mae) -1);
		write (mae, regMae);
	end;
	close (mae);
	close (det1);
	close (det2);
	close (det3);
end;

var
	det1,det2,det3: detalle;
	mae: maestro;
begin
	assign (mae, 'maestro');
	assign (det1, 'det1');
	assign (det2, 'det2');
	assign (det3, 'det3');
	actualizar (mae, det1,det2,det3);
end.
		
			
		


	

