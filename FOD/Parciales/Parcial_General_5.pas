program Parcial_General_5;
type
	prenda =record
		cod_prenda: integer;
		des: string[50];
		tipo_prenda: integer;
		stock: integer;
		precioUni: real;
	end;
	
archPrendas = file of prenda;
codEliminar = file of integer;


procedure cambioTemporada (var AP: archPrendas; var delete: codEliminar);
var
	cod: integer;
	pos:integer;
	reg: prenda;

begin
	reset (delete);
	reset (AP);
	while (not(EOF(delete))) do begin
		read (delete, cod);
		seek (AP, 0);	
		read (AP, reg);
		while (reg.cod_prenda <> cod) do begin
			read (AP, reg);
		end;
		seek (AP, filepos(AP) -1);
		reg.stock:=-1;
		write (AP, reg);
	end;
	seek (AP, 0);
	while (not(EOF(AP))) do begin
		read (AP, reg);
		if (reg.cod_prenda < 0) then begin
			pos:= filepos(AP) -1;
			seek (AP, filesize (AP) -1);
			read (AP, reg);
			if (filepos(AP) -1 <> 0) then begin
				while (reg.stock < 0) do begin
					seek (AP, filesize (AP) -1);
					truncate (AP);
					seek (AP, filesize (AP) -1);
					read (AP, reg);
				end;
			end;
			seek (AP, pos);
			write (AP, reg);
			seek (AP, filesize (AP)-1);
			truncate(AP);
			seek(AP,pos);
		end;
	end;
		
		
		
end;

begin
end.
