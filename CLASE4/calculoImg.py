import cv2
cc = cv2.CascadeClassifier(cv2.data.haarcascades + "haarcascade_frontalface_default.xml")
imgOriginal = cv2.imread("img.png")
imgGrises = cv2.cvtColor(imgOriginal, cv2.COLOR_BGR2GRAY)

#detectar rostros
rostros = cc.detectMultiScale(imgGrises, scaleFactor=1.1,minNeighbors=5, minSize=(30,30), flags=cv2.CASCADE_SCALE_IMAGE)

print("se encontraron {0} rostros".format(len(rostros)))

# mostrar los rostros detectados
for (x, y, w, h) in rostros:
    cv2.rectangle(imgOriginal, (x, y), (x+w, y+h), (0, 255, 0), 2)
cv2.imshow("rostros encontrados", imgOriginal)
cv2.waitKey(0)