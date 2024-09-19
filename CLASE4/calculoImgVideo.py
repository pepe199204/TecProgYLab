import cv2
cc = cv2.CascadeClassifier(cv2.data.haarcascades + "haarcascade_frontalface_default.xml")
vc = cv2.VideoCapture(0)

while True:
    ret, frame = vc.read()
    imgGrises = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    
    #detectar rostro
    rostros = cc.detectMultiScale(imgGrises, scaleFactor=1.1,minNeighbors=5, minSize=(30,30), flags=cv2.CASCADE_SCALE_IMAGE)
    
    # mostrar los rostros detectados
    for (x, y, w, h) in rostros:
        cv2.rectangle(frame, (x, y), (x+w, y+h), (0, 255, 0), 2)
        
    cv2.imshow("Video", frame)
    if cv2.waitKey(1) & 0XFF == ord('q'):
        break
vc.release()
cv2.destroyAllWindows()