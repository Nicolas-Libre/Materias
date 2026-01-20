program Parcial_2022_7_6;
Const
	valorFin = 'ZZZ';
Type
	venta = record
		razon_libreria: string [30];
		genero: string [30];
		nombreLibro: string [50];
		precio: real;
		cantVendida: integeR;
	end;
	
archivo = file of venta;

procedure leer (var a: archivo; var v:venta);
begin
	if (not(EOF(a))) then begin
		read (a, v);
	end
	else
		v.razon_libreria:= valorFin
end;
//Libreria - Genero - Nombre

procedure corte_de_control (var a: archivo);
var
	v: venta;
	rLibreriaAct, generoAct, libroAct: string;
	precioTotal, precioGenero, precioLibreria, precioLibro: real;
	totLibro: integer;
begin
	reset (a);
	precioTotal:= 0;
	leer (a,v);
	while (v.razon_libreria <> valorFin) do begin
		rLibreriaAct:= v.razon_libreria;
		precioLibreria:= 0;
		writeln ('Libreria: ', rLibreriaAct);
		while (rLibreriaAct = v.razon_libreria) do begin
			precioGenero:=0;
			generoAct:= v.genero;
			writeln ('Genero: ', generoAct);
			while ((rLibreriaAct = v.razon_libreria) and (generoAct = v.genero)) do begin
				totLibro:=0;
				libroAct:= v.nombreLibro;
				writeln ('Nombre del libro: ', libroAct);
				precioLibro:=0;
				while ((rLibreriaAct = v.razon_libreria) and (generoAct = v.genero) and (libroAct = v.nombreLibro)) do begin
					precioLibro:= precioLibro + v.precio;
					totLibro:= totLibro + v.cantVendida;
					leer (a,v);
				end;
				writeln ('Total Vendido del libro: ', totLibro, '. Precio acumulado del libro: ', precioLibro);
				precioGenero:= precioGenero + precioLibro;
			end;
			writeln ('Monto vendido del genero ', generoAct, ': ', precioGenero);
			precioLibreria:= precioLibreria + precioGenero;
		end;
		writeln ('Monto vendido de la libreria ', rLibreriaAct, ': ', precioLibreria);
		precioTotal:= precioTotal + precioLibreria;
	end;
	writeln ('Monto total librerias: ', precioTotal);
	close (a);
end;
			
	
var
	a: archivo;
begin
	assign (a, 'corte de control');
	corte_de_control (a);
end.
