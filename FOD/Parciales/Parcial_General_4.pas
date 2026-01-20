program Parcial_General_4;
Const
	VA = 9999;
type
venta = record
	codSucu: integer;
	IdAutor: integer;
	ISBN: integer;
	IdEj: integer;
end;

tArchVenta = file of venta;

procedure leer (var aVenta:tArchVenta; var v:venta);
begin
	if (not(EOF(aVenta))) then begin
		read (aVenta, v);
	end
	else begin
		v.codSucu:=VA
	end;
end;

procedure totalizar (var aVenta: tArchVenta; var informe: text; nom: string);
var
	regV: venta;
	vAct: venta;
	totalDeISBN, totalDeAutor, totalDeSucursal, totalGeneral: integer;
begin
	reset (aVenta);
	assign (informe, nom);
	rewrite (informe);
	leer (aVenta, regV);
	totalGeneral:=0;
	while (regV.codSucu <> VA) do begin
		vAct.codSucu:= regV.codSucu;
		totalDeSucursal:=0;
		writeln (informe, 'Codigo Sucursal: ', vAct.codSucu);
		while (vAct.codSucu = regV.codSucu) do begin
			totalDeAutor:=0;
			vAct.IdAutor:= regV.IdAutor;
			writeln (informe, 'Identificacion del ajutor ', vAct.IdAutor);
			while ((vAct.codSucu = regV.codSucu) and (vAct.IdAutor = regV.IdAutor)) do begin
				totalDeISBN:=0;
				vAct.ISBN:= regV.ISBN;
				while ((vAct.codSucu = regV.codSucu) and (vAct.IdAutor = regV.IdAutor) and (vAct.ISBN = regV.ISBN)) do begin
					totalDeISBN:= totalDeISBN +1;
					leer (aVenta, regV);
				end;
				writeln (informe, 'ISBN: ', vAct.ISBN, '. Total de ejemplares vendidos: ', totalDeISBN);
				totalDeAutor:= totalDeAutor + totalDeISBN;
			end;
			writeln (informe, 'Total de ejemplares vendidos del autor: ', totalDeAutor);
			totalDeSucursal:= totalDeSucursal + totalDeAutor;
		end;
		writeln (informe, 'Total de ejemplares vendidos por la sucursal: ', totalDeSucursal);
		totalGeneral:= totalGeneral + totalDeSucursal;
	end;
	writeln (informe, 'TOTAL GENERAL DE EJEMPLARES VENDIDOS: ', totalGeneral); 
	close (aVenta);
	close (informe);
end;

begin
	
end.
