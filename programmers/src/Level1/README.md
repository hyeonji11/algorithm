## 1. 크레인 인형뽑기 게임(ClawMachineGame.java)

Stack을 이용해 바구니에 인형을 넣고, 터트리는 행위를 구현했다.

```
if(board[i][value-1] != 0) {
  if(!stack.isEmpty()) {
    if(stack.peek() == board[i][value-1]) {
      stack.pop();
      board[i][value-1] = 0;
      answer++;
      break;
    }
  }
  stack.push(board[i][value-1]);
  board[i][value-1] = 0;
  break;
}
```

answer에는 터지는 횟수를 저장하고 리턴할 때 2는 곱해서 리턴했다.
터지는 횟수 대신 answer += 2; 로 저장해서 리턴하는 방법도 있다.

## 2. 두 개 뽑아서 더하기(TwoNumberSum.java)

두 수를 뽑은 결과를 HashSet에 넣어서 중복을 방지하고, 배열에 넣은 뒤 Arrays.sort()를 이용해 정렬했다.

다른 사람들은 아래 코드로 정렬과 배열로 바꾸는 과정을 구현했다.
```
set.stream().sorted().mapToInt(Integer::intValue).toArray()
```

## 3. 신규 아이디 추천(NewIdRecommend.java)

특정 문자를 제외한 특수문자를 제거하는 작업은 정규식을 사용해서 구현했다.
```
answer = answer.replaceAll("[^a-z0-9-_.]", "");
```

반복되는 문자 제거 작업도 정규식을 사용했다.
```
answer = answer.replaceAll("[.]{2,}", ".");
```

다른 사람의 풀이에서는 첫 문자와 끝 문자가 마침표(.)일때 제거하는 작업도 정규식을 사용했다.
```
answer = answer.replaceAll("^[.]|[.]$","");
```

## 4. 모의고사(MockTest.java)

수포자의 찍는 패턴을 배열에 저장해서 하나씩 비교하는 식으로 구현했다.
```
int[][] pattern = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};

for(int i=0; i<3; i++) {
  for(int j=0; j<answers.length; j++) {
    if(answers[j] == pattern[i][count]) {
      answer[i]++;
    }
    count++;
    if(count == pattern[i].length)
      count = 0;
  }
  count = 0;
}
```

최고 점수를 구하는 부분은 원래 반복문으로 구현했지만 Math.max()를 통해 더 간결하게 구현할 수 있어서 수정했다.
```
int max = Math.max(answer[0], Math.max(answer[1], answer[2]));
```

## 5. 3진법 뒤집기(TernaryNotationReverse.java)

10진법을 3진법으로 바꾸는 작업은 while문을 이용해 3으로 나눈 나머지를 list에 넣는 식으로 구현했다.
```
while(n>0) {
  list.add(n%3);
  n = n/3;
}
```

3진법을 뒤집고 10진법으로 바꾸는 작업은 Math.pow() 를 이용해 구현했다.
```
for(int i=list.size()-1; i>=0; i--) {
  answer += Math.pow(3, list.size()-i-1)*list.get(i);
}
```

## 6. 체육복(GymUniform.java)

첫 번째 이중 for문에서는 도난당한 사람과 여분 체육복이 있는 사람이 같으면 -1로 만들어서 제외하는 작업을 했다.
```
for(int i=0; i<lostSize; i++) {
  for(int j=0; j<resSize; j++) {
    if(lost[i] == reserve[j]) {
      lost[i] = -1;
      reserve[j] = -1;
    }
  }
}
```

두 번째 이중 for문에서는 Math.abs()를 이용해 도난당한 사람이 여분 체육복을 가진 사람의 앞, 뒤 사람이면 제외시키는 작업을 했다.
```
for(int i=0; i<lostSize; i++) {
  for(int j=0; j<resSize; j++) {
    if(Math.abs(reserve[j] - lost[i])<2) {
      lost[i] = -1;
      reserve[j] = -1;
    }
  }
}
```

처음엔 while문으로 안에 여러가지 if문을 넣어서 했는데 시간초과가 나서 작업을 쪼개서 for문으로 구현했더니 통과되었다.

## 7. 예산(Budget.java)

신청 금액 배열을 오름차순으로 정렬한 다음 예산에서 작은 금액부터 빼면서 예산을 초과하면 반복문을 나가도록 구현했다.
```
for(int i=0; i<d.length; i++) {
  if(budget-d[i] >= 0) {
    budget -= d[i];
    answer++;
  } else break;
}
```

## 8. 비밀지도(SecretMap.java)

지도 암호를 해독하는 과정을 for문으로 하나씩 나눠주면서 작업했는데 문제 해설과 다른 사람들의 풀이를 보니 비트연산으로 간단하게 할 수 있다는 것을 알게되었다.

```
for(int i=0; i<n; i++) {
  for(int j=n-1; j>=0; j--) {
    res[i][j] = arr[i] % 2;
    arr[i] /= 2;
    if(arr[i] == 0)
      break;
  }
}
```
위의 코드에서 아래 코드로 수정했다.
```
for(int i=0; i<n; i++) {
  answer[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
}
```

이진수 앞에 부족한 부분은 공백으로 바꿔야하는데 아래 첫 번째 코드를 쓰면 실행 시간이 느려서 두 번째 코드로 구현했다.
```
answer[i] = String.format("%"+n+"s", answer[i]);
```
```
int size = answer[i].length();
for(int j=0; j<n-size; j++) {
  answer[i] = " "+answer[i];
}
```