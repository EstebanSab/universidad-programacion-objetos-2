import networkx as nx
import matplotlib.pyplot as plt

class Bus:
    def __init__(self):
        self.Mapa = nx.Graph()
        self.MapaD=nx.DiGraph()
        self.calles = {}
        self.cambiarSentido = []

    def leerArchivo(self,direccion):
        with open(direccion) as archivo:
            self.cont =0
            for linea in archivo:
                aux = linea.split(' ')
                aux[len(aux)-1]=aux[len(aux)-1].replace("\n", "") 

                if self.cont==0:
                    self.bus = str(aux[1])
                    self.escuela = str(aux[2])

                if self.cont>1:
                    self.Mapa.add_edge(str(aux[0]),str(aux[1]),weight=int(aux[2]))
                    self.MapaD.add_edge(str(aux[0]),str(aux[1]),weight=int(aux[2]))
                    self.calles[str(aux[0])+' '+str(aux[1])]= self.cont-1
                self.cont+=1 


    def recorrido(self):
        self.distanciaEscuela,self.caminoEscuela = nx.single_source_dijkstra(self.Mapa, self.bus)        
              
        camino = self.caminoEscuela[self.escuela]
        for nodo in range(0,len(camino)-1):
            try:
                #Devuelve el peso entre el camino[nodo] y camino[nodo+1]
                #si no hay camino posible(no dirigido) lanza excepcion
                nx.path_weight(self.MapaD, [camino[nodo],camino[nodo+1]],'weight')
            except:
                #invierto la direccion de la arista y obtengo su calle
                self.cambiarSentido.append(self.calles.get(camino[nodo+1]+' '+camino[nodo]))
            
    def escribirArchivo(self,a):
        f = open (a,'w')
        f.write(str(self.distanciaEscuela[self.escuela])+'\n')
        for x in self.cambiarSentido:
            f.write(str(x) + " ")
        f.close()



p = Bus()
p.leerArchivo("p.txt")
p.recorrido()
p.escribirArchivo("p00.txt")
