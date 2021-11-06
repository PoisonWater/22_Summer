// https://nataliekung.gitbook.io/ladder_code/twitter-oa/parking-dilemma

def ParkingDilemma(self, cars, k):
    # write your code here
    cars.sort()
    n = len(cars)
    res = float('inf')
    for i in range(n-k+1):
        res = min(res, cars[i+k-1] - cars[i])
    return res+1
