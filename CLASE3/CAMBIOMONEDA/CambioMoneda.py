#importar libreria para interfaz grafica de usuario
from tkinter import *
from tkinter.ttk import Notebook
from tkinter import messagebox
#importar libreria util
import Util
import pandas as pd

#Importar libreria para manejo de fechas y tiempo
from datetime import *

#Importar libreria para gráficas
from matplotlib import pyplot as plt

iconos = ["./icons/grafica.png", "./icons/db.png"]
textosBotones= ["Gráfica Cambio vs Fecha","Datos Estadísticos"]

df = None

def obtenerMonedas():
    global df
    df = pd.read_csv("./CambiosMonedas.csv")
    monedas = df["Moneda"].tolist()
    print(list(set(monedas)))
    return (list(set(monedas)))

def graficar():
    print("graficar")
    if cmbMoneda.current() >= 0:
        df.sort_values(by="Fecha",ascending=False).head()
        cambios = df[df["Moneda"]==monedas[cmbMoneda.current()]]
        y = cambios["Cambio"]
        fechas = cambios["Fecha"]
        x = [datetime.strptime(f, "%d/%m/%Y").date() for f in fechas]
        
        # crear gráfica
        plt.clf()
        plt.title("Cambios de " + monedas[cmbMoneda.current()])
        plt.ylabel("Cambios")
        plt.xlabel("Fechas")
        plt.plot(x, y)
        nombreImg = "GraficaCambiosMoneda.png"
        plt.savefig(nombreImg)
        
        #Mostrar gráfica
        Util.agregarImagen(paneles[0], nombreImg, 0, 0)
        # print(fechas)
        # print(x)
        nb.select(0)
    else:
        messagebox.showerror("Error graficando", "No ha seleccionado la moneda")

def estadisticas():
    print("estadisticas")
    if cmbMoneda.current() >= 0:
        cambios = df[df["Moneda"]==monedas[cmbMoneda.current()]]
        #mostrar la promedio
        Util.agregarEtiqueta(paneles[1], "Promedio:", 0, 0)
        # Util.agregarEtiqueta(paneles[1], "{0:,.2f}".format(cambios["Cambio"].mean()), 0, 1)
        Util.agregarEtiqueta(paneles[1], f"{cambios['Cambio'].mean():.2f}", 0, 1)
        
        #mostrar la desviación estandar
        Util.agregarEtiqueta(paneles[1], "Desviación:", 1, 0)
        Util.agregarEtiqueta(paneles[1], f"{cambios['Cambio'].std():.2f}", 1, 1)
        
        #mostrar la máximo
        Util.agregarEtiqueta(paneles[1], "Máximo:", 2, 0)
        Util.agregarEtiqueta(paneles[1], f"{cambios['Cambio'].max():.2f}", 2, 1)
        
        #mostrar la mínimo
        Util.agregarEtiqueta(paneles[1], "Mínimo:", 3, 0)
        Util.agregarEtiqueta(paneles[1], f"{cambios['Cambio'].min():.2f}", 3, 1)
        
        #mostrar la moda
        Util.agregarEtiqueta(paneles[1], "Moda:", 4, 0)
        f = 4
        for moda in cambios['Cambio'].mode():
            Util.agregarEtiqueta(paneles[1], f"{moda:.2f}", f, 1)
            f+=1
        
        nb.select(1)
    else:
        messagebox.showerror("Error en Estadísticas", "No ha seleccionado la moneda")
    
#crear una ventana
v = Util.crearVentana("Cambios de Monedas","500x400")
#agregar una barra de herramientas basada en
#una lista de archivos con imagenes
botones = Util.agregarBarra(v, iconos, textosBotones)
botones[0].configure(command = graficar)
botones[1].configure(command = estadisticas)
#agregar contenedor para la lista que permite escoger la moneda a procesar
frm = Frame(v)
frm.pack (side=TOP, fill=X)
Util.agregarEtiqueta(frm,"Moneda:", 0, 0)

monedas = obtenerMonedas() #Esta es la fuente de datos del combobox
cmbMoneda = Util.agregarLista(frm,monedas,0,1) #Agrega
#agregar panel de pestañas para mostrar resultados
nb = Notebook(v)
nb.pack (fill=BOTH, expand=YES)
encabezados = ["Gráfica","Datos"]
paneles = []
for e in encabezados:
    frm = Frame (v)
    paneles.append (frm)
    nb.add (frm, text=e)
    
frm.mainloop()