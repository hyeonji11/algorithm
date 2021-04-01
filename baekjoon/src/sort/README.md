## 1. 나이순 정렬(P10814_AgeSort.java)

입력으로 들어온 회원을 나이순, 가입순으로 정렬하는 문제다.
나이와 이름, 들어온 순서를 클래스 멤버변수로 만들고 입력이 들어올 때 ArrayList에 P10814_AgeSort 클래스 타입으로 저장했다.

정렬은 List의 sort()메소드를 이용했다. Comparator 익명클래스를 활용해 compare 메소드를 오버라이드해서 나이 오름차순으로 정렬, 나이가 같으면 순서 오름차순으로 정렬하도록 구현했다.

```
ageList.sort(new Comparator<P10814_AgeSort>() {
  @Override
  public int compare(P10814_AgeSort o1,P10814_AgeSort o2) {
    int age1 = o1.age;
    int age2 = o2.age;
    if(age1==age2) {
      if(o1.order > o2.order)
        return 1;
      else
        return -1;
    } else if(age1 > age2)
        return 1;
    else
      return -1;
  }
});
```

## 2. 베스트셀러(P1302_BestSeller.java)

HashMap을 이용해서 key에는 책 이름, value에는 책이 팔린 횟수를 저장했다.

HashMap의 value를 기준으로 내림차순 정렬을 한 후 같은 값이라면 key 사전순으로 정렬을 했다.

```
Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
  @Override
  public int compare(Map.Entry<String, Integer> o1,Map.Entry<String, Integer> o2) {
    if(o2.getValue()>o1.getValue()) return 1;
    else if(o2.getValue().equals(o1.getValue())) {
      return o1.getKey().compareTo(o2.getKey());
    }
    return -1;
  }
});
```

## 3. ATM(P11399_ATM.java)

돈을 인출하는데 필요한 시간이 최소가 되려면 인출하는 순서가 인출 시간이 제일 적게 걸리는 사람부터 해야된다.
인출 시간을 오름차순으로 먼저 정렬한 다음 인출하는데 걸리는 시간을 차례차례 더한 값을 출력했다.

오름차순 정렬은 단순 int배열 정렬이기 때문에 Arrays.sort()를 이용했다.