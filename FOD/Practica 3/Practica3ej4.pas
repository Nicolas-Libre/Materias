program practica3ej4;
Const
type
	reg_flor = record
		nombre: String[45];
		codigo: integer;
	end;
tArchFlores = file of reg_flor;

procedure agregarFlor (var a: tArchFlores; nombre: string; codigo:integer);
var
	flor:reg_flor;
begin
	flor.nombre:= nombre;
	flor.codigo:= codigo;


end;

var

begin

end.







