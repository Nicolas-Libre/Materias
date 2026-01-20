program Parcial_2023_8_8;
Const
	DF = 20;
	VA = 9999;
type
	producto = record
		cod: integer;
		nom: string [30];
		precio: real;
		stockAct: integer;
		stockMin: integer;
	end;
	
	venta = record
		cod: integer;
		cantVendida: integer;
	end;
	
detalle = file of venta;
maestro = file of producto;

vec_deta = array [1..DF] of detalle;
vec_regiDeta = array [1..DF] of venta;

procedure leer (var det: detalle; var v:venta);
begin
	if (not(EOF(det))) then begin
		read(det,v);
	end
	else 
		v.cod:=VA;
end;

procedure minimo (var vDetalles: vec_deta; var vRegiDetalles: vec_regiDeta; var min: venta);
var
	i: integer;
	pos: integer;
begin
	min.cod:=VA;
	for i:= 1 to DF do begin
		if (vRegiDetalles[i].cod < min.cod) then begin
			min:= vRegiDetalles[i];
			pos:=i;
		end;
	end;
	if (min.cod <> VA) then begin
		leer (vDetalles[pos], vRegiDetalles[pos]);
	end;
end;

procedure Parcial (var mae: maestro; var informe: Text; var vDetalles: vec_Deta);
var
	vRegiDetalles: vec_regiDeta;
	min: venta;
	i: integer;
	regMae: producto;
	totVendida: integer;
	montoTotal: real;
begin
	for i:= 1 to DF do begin
		reset (vDetalles [i]);
		leer (vDetalles[i], vRegiDetalles[i]);
	end;
	reset (mae);
	minimo (vDetalles, vRegiDetalles, min);
	rewrite (informe);
	writeln (informe, 'Los siguientes productos vendidos superaron los 10000 pesos: '); 
	while (min.cod <> VA) do begin
		read (mae, regMae);
		while (regMae.cod <> min.cod) do begin
			read (mae, regMae);
		end;
		totVendida:=0;
		montoTotal:=0;
		while (regMae.cod = min.cod) do begin
			totVendida:= totVendida + min.cantVendida;
			minimo (vDetalles, vRegiDetalles, min);
		end;
		if (regMae.stockAct > totVendida) then begin
			regMae.stockAct:= regMae.stockAct - totVendida;
		end
		else regMae.stockAct:=0;
		montoTotal:= regMae.precio * totVendida;
		if (montoTotal > 10000) then begin
			with regMae do begin
				writeln (informe, ' ', cod, ' ', nom, ' ', precio, ' ', stockAct, ' ', stockMin);
			end;
		end;
		seek (mae, filepos(mae) -1);
		write (mae, regMae);
	end;
	for i:= 1 to DF do begin
		close (vDetalles[i]);
	end;
	close (mae);
	close (informe);
end;
		
			
			
var
	mae: maestro;
	vDetalles: vec_deta;
	informe: Text;
	i: integer;
	cadenaI: string;
begin
	assign (mae, 'maestro');
	for i:= 1 to DF do begin
		Str (i, cadenaI);
		assign (vDetalles[i], 'detalle ' + cadenaI);
	end;
	assign (informe, 'Informe');
	Parcial (mae, informe, vDetalles);
end.
	

		
	
