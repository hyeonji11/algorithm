## 1. 124 나라의 숫자(NumberOf124Country.java)

처음엔 완전탐색 문제로 알고 풀었지만 n이 너무 큰 숫자가 들어오면 시간초과가 나기 때문에 3진법을 이용하는 방법으로 풀었다.

n을 3으로 나눈 나머지가 1이면 1, 2면 2, 0이면 4로 대입하고 그 몫을 다시 3으로 나누는 과정을 반복했다.

또한, 3으로 나눠서 나머지가 0일 때 몫은 -1을 해줘야 되는 규칙이 있다.

```
String[] arr = {"4", "1", "2"};

while(n >0) {
  int mod = n % 3;
  for(int i=0; i<3; i++) {
    if(mod == i) {
    answer = arr[i] + answer;
    }
  }
  n = n/3;
  if(mod == 0) n--;
}
```

## 2. 올바른 괄호(CorrectParenthesis.java)

Stack을 이용해 Stack 안에 '('가 들어있고 현재 들어가려는 문자가 ')'일 때 stack에서 '(' 빼는 작업을 반복적으로 하게끔 구현했다.

마지막에 stack이 비어있으면 true, 비어있지 않으면 false를 리턴하도록 했다.

## 3. 프린터(Printer.java)

Printer 클래스에 중요도에 따른 인쇄 순서 order와 내가 인쇄를 요청한 문서인지 아닌지 확인하는 check 변수를 선언하고 location과 같은 위치인 문서만 check 변수에 true값을 저장했다.

count 배열에는 중요도에 따른 인쇄순서를 다 저장하고 오름차순 정렬했다.

ArrayList에 priorities 배열 순서대로 Printer클래스를 넣는 작업을 한 뒤에 count 배열의 인쇄 순서와 ArrayList queue의 인쇄 순서를 비교하며 순서가 같으면 ArrayList에서 삭제하고 순서가 다르면 ArrayList의 마지막으로 가게끔 구현했다.
```
while(queue.size()>0) {
  Printer p = queue.get(0);
  queue.remove(0);
  if(count[idx] == p.order) {
    idx++;
    if(p.check) break;
  } else {
    queue.add(p);
  }
}
```

## 4. 더 맵게(Spicier.java)

PriorityQueue를 이용해서 제일 작은 스코빌 지수와 두번째로 작은 스코빌 지수를 섞는 작업을 하고, 제일 작은 숫자가 K보다 크거나 같아지거나 PriorityQueue의 사이즈가 1보다 작거나 같아지면 while문을 빠져나오도록 구현했다.
```
while(pq.peek() <= K && pq.size() > 1) {
  int num1 = pq.poll();
  int num2 = pq.poll();
  int newNum = num1 + num2*2;
  pq.add(newNum);
  answer++;
}
```

## 5. 큰 수 만들기(CreateBigNumber.java)

일단 number의 길이에서 k개의 수를 빼서 만들어야되는 수의 길이를 numLen에 저장했다.
그 다음 만들어야되는 수의 길이 충족하려면 시작해야되는 최소 지점의 인덱스를 fIdx, 맨 처음 인덱스 sIdx로 정해서 그 구간에서 최대값을 찾아 결과 문자열에 추가하도록 구현했다.
루프를 돌면서 최대값이 한개씩 저장이 되기 때문에 fIdx는 1씩 증가되고, sIdx는 최대값의 다음 인덱스를 저장하도록 구현했다.

예를 들어 number의 길이가 5, k는 3이라면 결과 문자열의 길이는 2가 된다.
이 수를 만들려면 최소한 4번째 숫자부터는 시작해야 되기 때문에 fIdx는 4, sIdx는 1이여야 하지만 배열 인덱스가 0부터 시작이기 때문에 1씩 빼서 fIdx는 3, sIdx는 0이 된다.
루프를 돌면서 (0, 3) 구간에서 최대값의 인덱스가 2라면 다음 루프의 구간은 (3, 4)가 된다.

루프 구간에서 최대값이 아닌 수들은 제거해야 되기 때문에 그 수만큼 k에서 빼주고 k가 0이 되거나 만들어야되는 수의 길이가 충족된다면 루프를 빠져나온다.

처음 문자열을 붙이는 작업은 '+' 연산자를 이용해서 구현했지만 조금이라도 속도를 개선하기 위해 StringBuilder의 append() 메소드를 사용해서 구현하는 것으로 수정했다.

```
while(k>0 && sb.length() < numLen) {
  int max = -1;
  int maxIdx = -1;
  for(int i=sIdx; i<=fIdx; i++) {
    if(max<num[i]) {
      max = num[i];
      maxIdx = i;
    }
  }
  k = k-(maxIdx - sIdx);
  sIdx = maxIdx+1;
  fIdx++;
  sb.append(arr[maxIdx]);
}
```

## 6. 오픈채팅방(OpenChattingRoom.java)

HashMap에 대해 알고있으면 쉽게 풀 수 있는 문제였다.
record배열 요소의 첫 단어가 Enter 또는 Change라면 HashMap에 <유저아이디, 닉네임> 형식으로 저장했다.

그 후엔 record 요소의 첫 단어가 Enter 또는 Leave 면 그 요소의 유저아이디로 최종 닉네임을 찾아서 각각 맞는 문구를 붙여 ArrayList에 추가했다.
마지막엔 ArrayList를 배열로 바꿔서 리턴했다.

## 7. 다리를 지나는 트럭(PassBridge.java)

다리에 올라간 시간을 저장하는 Queue bridge_time과 다리에 올라간 트럭의 무게를 저장하는 Queue bridge_weight 두개를 이용했다.
현재 시간 time과 bridge_time의 맨앞 요소의 차이가 다리 길이와 같으면 위 두개의 Queue에서 맨앞 요소들을 제거했다.

다리에 올라간 트럭 무게의 합에 다음 올라갈 트럭 무게를 더해도 weight보다 작다면 위 두개의 Queue에 각각 현재 시간과 다음 올라갈 트럭의 무게를 저장했다.
```
if(idx<truck_weights.length && truck_weights[idx]+curWeight <= weight) {
  curWeight += truck_weights[idx];
  bridge_time.add(time);
  bridge_truck.add(truck_weights[idx]);
  idx++;
}
```

위 과정을 반복하고 bridge_time이 비었을 때 종료하도록 구현했다.

## 8. 스킬트리(SkillTree.java)

정규식을 이용해서 skill_trees의 원소에 skill 문자열을 뺀 다른 문자들을 ""로 대체하도록 구현했다.
```
skill_trees[i] = skill_trees[i].replaceAll("[^"+skill+"]", "");
```

그 뒤엔 skill을 skill_trees의 원소 길이에 맞춰서 자르고 두 문자열이 일치하는지 비교하여 일치하면 answer를 1씩 올리도록 구현했다.
```
String str = skill.substring(0, skill_trees[i].length());
if(str.equals(skill_trees[i])) answer++;
```

## 9. 튜플(Tuple.java)

일단 정규식을 이용해서 문자 '{', '}' 두개를 제거하는 작업을 했다.
```
String str[] = s.replaceAll("[{}]", "").split(",");
```

그 뒤엔 HashMap을 이용해서 튜플의 원소들을 각각 key로 설정하고, 튜플 표현 집합 s에 key들의 횟수를 세서 value에 넣었다.

다 넣고 나서 value값을 기준으로 내림차순으로 정렬한 후 value를 answer 배열에 담아 리턴했다.

다른 사람의 풀이를 보니 HashSet을 이용하면 더 간단하게 풀 수 있었다. HashSet에 add() 메소드는 인자로 전달된 아이템이 HashSet에 없다면 true, 있다면 false를 리턴하기 때문에 이 특성을 이용해서 풀 수 있다.
HashSet.add() 메소드가 리턴값이 있는지 몰랐는데 다음에 비슷한 문제를 풀 때 적용하면 좋을 것 같다.

## 10. 영어 끝말잇기(EnglishWordChain.java)

문제의 끝말있기에서 탈락자가 발생하는 조건은 앞 단어의 마지막 문자로 단어를 시작하지 않을 때와 등장했던 단어를 또 사용할 때이다.

앞 단어의 마지막 문자로 단어를 시작하는것은 String 클래스의 endsWith() 메소드를 이용해 확인했고, 중복되는 단어는 HashSet의 add() 메소드를 이용해 확인했다.
```
for(int i=1; i<words.length; i++) {
  if(!words[i-1].endsWith(words[i].substring(0, 1)) || !hs.add(words[i)) {
    answer[0] = (i+1)%n == 0 ? n : (i+1)%n;
    answer[1] = i/n +1;
    break;
  }
}
```

## 11. 땅따먹기(Ttangttameokgi.java)

DP문제를 처음 풀어봐서 처음엔 답을 보고 2주 뒤에 다시 풀어 봤다.
푼 방식은 이전 행에서 최대값을 다음 행의 숫자들에 더하는 방식이다. 단, 연속으로 같은 열에서 선택할 수 없기 때문에 현재 2열에 있다면 2열을 뺀 나머지 열에서 최대값을 선택해 현재2열에 더한다.

이 문제는 4열로 열의 수가 고정되어 있지만 만약 고정되지 않은 비슷한 문제가 있다면 최대값을 구하는 코드를 Math.max() 대신 다른 코드로 바꾸면 될 것 같다.
```
for(int i=1; i<land.length; i++) {
  land[i][0] += Math.max(land[i-1][1], Math.max(land[i-1][2], land[i-1[3]));
  land[i][1] += Math.max(land[i-1][0], Math.max(land[i-1][2], land[i-1[3]));
  land[i][2] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1[3]));
  land[i][3] += Math.max(land[i-1][0], Math.max(land[i-1][1], land[i-1[2]));
}
```