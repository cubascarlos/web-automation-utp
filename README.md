# Recomendaciones para el uso del framework
#### 1. Las clases Page deben extender de la clase BaseWeb para obtener acceso directo al driver() instanciado y a las anotaciones @FinBy de page factory.


# Ejecución de pruebas:

### En la etiqueta tag de la clase Runner ingresar el tag a ejecutar:
#### Unitario: tags = "@Test01" | 
#### Multiple: tags = "@Test01 or @Test02"
#### Negar: tags = "not @Test01"
#### Compuesto: tags = "@CDSC-002 and @cer"

# Comando para ejecución por consola/terminal.
## Para ejecutar por tag:
#### mvn clean verify -Dcucumber.filter.tags=@CDSC-001
## Para ejecutar por todo un feature:
#### mvn clean verify -Dcucumber.features=path/file.feature




