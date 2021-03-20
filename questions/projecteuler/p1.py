def multiples():
  muls = set()

  three = 3
  five = 5

  while three < 1000 or five < 1000:
    if three < 1000:
      muls.add(three)
      three += 3
    if five < 1000:
      muls.add(five)
      five += 5

  print(muls)
  return sum(muls)
  
print(multiples())