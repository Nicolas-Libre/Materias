program Parcial_1;
Const
VA = 9999;
type

producto = record
	cod: integer;
	nom: string[30];
	desc: string [50];
	barras: integer;
	cat: string[30];
	stockAct: integer;
	stockMin: integer;
end;

pedido = record
	cod: integer;
	cantPedida: integer;
	desc: string[50];	
end;

detalle = file of pedido;
maestro = file of producto;

procedure leer (var det: detalle; var p: pedido);
begin
	if (not(EOF(det))) then begin 
		read (det, p);
	end
	else begin
		p.cod := VA;
	end;
end;

procedure minimo (var min: pedido; var r_det1,r_det2,r_det3: pedido; var det1,det2,det3: detalle);
begin
	if ((r_det1.cod < r_det2.cod) and (r_det1.cod < r_det3.cod)) then begin
		min := r_det1;
		leer (det1, r_det1);
	end
	else if (r_det2.cod < r_det3.cod) then begin
		min := r_det2;
		leer (det2, r_det2);
	end
	else begin
		min := r_det3;
		leer(det3, r_det3);
	end;
end;

procedure actualizar (var mae: maestro; var det1,det2,det3: detalle);
var
	min: pedido;
	r_det1,r_det2,r_det3: pedido;
	r_mae: producto;
	cantTotalPedida: integer;
	dif: integer;
begin
	reset (mae);
	reset (det1); reset (det2); reset (det3);
	read (mae, r_mae);
	leer (det1, r_det1);
	leer (det2, r_det2);
	leer (det3, r_det3);
	minimo (min, r_det1, r_det2, r_det3, det1, det2, det3);
	while (min.cod <> VA) do begin
		cantTotalPedida:= 0;
		read (mae, r_mae);
		while (r_mae.cod <> min.cod) do begin
			read (mae,r_mae);
		end;
		while (r_mae.cod = min.cod) do begin
			cantTotalPedida:= cantTotalPedida + min.cantPedida;
			minimo (min, r_det1, r_det2, r_det3, det1, det2, det3);
		end;
		if (r_mae.stockAct < cantTotalPedida) then begin
			dif := cantTotalPedida - r_mae.stockAct;
			writeln ('El pedido del producto llamado ',r_mae.nom, 
						' con codigo ', r_mae.cod,
							' no se puede satisfacer. Diferencia entre lo pedido y lo que se tiene: ', dif);
			r_mae.stockAct:= 0;
		end
		else begin
			r_mae.stockAct:= r_mae.stockAct - cantTotalPedida;
		end;
		if (r_mae.stockAct < r_mae.stockMin) then begin
			writeln ('El producto llamado ', r_mae.nom, ' con codigo ', r_mae.cod, 
						' tiene el stock Actual menor que el minimo. Pertenece a la categoria ', r_mae.cat);
		end;
		seek (mae, filepos(mae) -1);
		write (mae, r_mae);
	end;
	close (mae);
	close (det1); close (det2); close (det3);
end;
		
			
var
	mae:maestro;
	det1,det2,det3: detalle;
begin
	assign (mae, 'maestro');
	assign (det1, 'det1');
	assign (det2, 'det2');
	assign (det3, 'det3');
	actualizar (mae,det1,det2,det3);
end.






