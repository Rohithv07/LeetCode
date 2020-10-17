class Fancy(object):

    def __init__(self):
        self.A = []
        self.add = [0]
        self.mul = [1]

    def append(self, a):
        self.A.append(a)
        self.add.append(self.add[-1])
        self.mul.append(self.mul[-1])

    def addAll(self, inc):
        self.add[-1] += inc

    def multAll(self, m):
        self.add[-1] *= m
        self.mul[-1] *= m

    def getIndex(self, i):
        if i >= len(self.A): return -1
        m = self.mul[-1] // self.mul[i]
        inc = self.add[-1] - self.add[i] * m
        return int((self.A[i] * m + inc) % (10 ** 9 + 7))
