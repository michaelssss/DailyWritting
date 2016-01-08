class QuickSort(object):
    def __init__(self):
        self.list = [2, 1, 3, 5, 4, 6]

    def quicksort1(self, arr):

        if len(arr) <= 1:
            return arr
        arr1 = []
        arr2 = []
        for index in arr:
            if index > arr[0]:
                arr1.append(index)
            if index < arr[0]:
                arr2.append(index)
        return self.quicksort1(arr2) + [arr[0]] + self.quicksort1(arr1)


quicksort = QuickSort()

print(quicksort.quicksort1(quicksort.list))
