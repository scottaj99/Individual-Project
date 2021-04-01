class Main:
    def main(args):
        i = 3
        switchVal = i
        if 2==1:
            #to remove, unreachable condition
            print("error")
        elif switchVal==0:
            i+=1

        elif switchVal==2:
            i-=1

        elif switchVal==3:
            i-=2

        else:
            i=1
        print(i)

