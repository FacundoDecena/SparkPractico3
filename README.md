# Practico 3
## Spark, Velocity y SQL

Cada carpeta es un proyecto por separado


Para ejecutar cada proyecto debe situarse en la raiz del mismo, tener maven instalado en su computadora y ejecutar el siguiente comando por consola:  

```bash
mvn exec:java -Dexec.mainClass="main.Main"
```

```
/api/departamentos
?                       | Todos los departamentos
?director=x             | Departamentos con director x
?deptoConEmpleado=true  | Departamentos con almenos un empleado
```

```
/api/empleados
?dedicacion={Media Jornada, Jornada Completa, Tercerizado}  | Empleados con dicha dedicacion
?codigo=x                                                   | Empleados del departamento x
director=true                                               | Empleado que tambien es director
```

```
/empleados          | Empleados de un departamento
/depto              | Departamento de un empleado
/cant-empleados     | Cantidad de empleados que tiene cada departamento
/add-depto          | Agrega un departamento
/add-empleado       | Agrega un empleado
```
