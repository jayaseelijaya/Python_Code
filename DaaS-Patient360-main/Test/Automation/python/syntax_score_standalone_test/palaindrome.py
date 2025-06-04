
data = "MalayalaM"

print(data[::-1])

for i in range(len(data)):
    print(len(data)-1)


input = 121



# name = {'name':'jaya','age':'3'}

# name.keys()
# name['name']

# m = {'1','2','3','4'}
name = ''

  

class database:
    
    def data(self):
        self.name = {'11': 'sita','12':'jaya','13':'rama'}
        
    
class school(database):
      
    def name(self,a):
        #self.data()
        data(self).name[a]
        return data(self).name[a]
    
obj = school()
s = obj.name('11')
print(s)


