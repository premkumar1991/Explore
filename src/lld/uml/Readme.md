# plantuml is used all over the system for uml class diagram design, frequently used syntax

# inheritance, interface_implementation, use words explicitly
```classA extends classB
classA implements classB
```
# association 
```
classA "1" --> "1" classB : relationship
classA "1" --> "*" classB : relationship
classA "*" --> "*" classB : relationship
```
# aggregation 
```
classA "1" o-- "1" classB : relationship
```

# composition
```
classA "1" *-- "1" classB : relationship
```


# private,public,protected
```
- private
+ public
# protected
```

# inheritance
```
classA --> classB : relationship
```


