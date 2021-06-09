# GIT.CONTROL DE VERSIONES


## Tarea 4.3. Comandos básicos en local.
Escribe los comandos según su descripción:
1.   Transforma el directorio actual en un repositorio de Git. Se añade un subdirectorio de .git con todos los archivos necesarios del repositorio
      - git init     
2.   Especifica qué archivos quieres añadir al repositorio (a staging area, staged). Prepara los archivos modificados
      - git add 
3.   Confirma los cambios (a directorio git, committed)
      - git commit  
4.   Clona un repositorio existente
      - git clone (nombre del repositorio)
5.   Muestra el estado de los archivos
      - git status
6.   Muestra estado abreviado
      - git status -s
7.   Ignora archivos
      - git ignore
8.   Mostrar los cambios: líneas exactas que fueron añadidas y eliminadas. Compara lo que tienes en tu directorio de trabajo con lo que está en el área de preparación
      - git diff --staged
10.  Mostrar los cambios: líneas exactas que fueron añadidas y eliminadas. Compara tus cambios preparados con la última instantánea confirmada
      - git 
11.  Confirma los cambios sin pasar por el área de preparación (a directorio git, committed)
      - git commit -a -m (Mensaje)
12.  Eliminar archivos del directorio de trabajo y del área de preparación
      - git rm
13.  Renombrar archivos del directorio de trabajo y del área de preparación
      - git mv file_from file_to
14.  Muestra el historial de confirmaciones
      - git log
15.  Muestra sólo las dos últimas confirmaciones indicando las diferencias introducidas en cada confirmación 
      - git log -p -2
16.  Rectifica el último commit
      - git commit --amend
17.  Deshaz un archivo preparado (indicado en git status)
      - git reset
18.  Deshaz un archivo modificado (peligroso) (indicado en git status)
      - git checkout -- nombre archivo