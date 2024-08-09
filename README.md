# 👩🏼‍🤝‍🧑🏻 소모임 생성 서비스 - QUICK BUDDIES

## 프로젝트 소개

- QUICK BUDDIES는 영화, 배드민턴 등 혼자 하기 어려운 취미들을 가까운 지역에 사는 사람들끼리 시간대를 맞춰 번개모임을 만들어주는 서비스입니다.
- 모임을 만들고 싶은 사람은 게시판에 글을 써서 인원을 모집할 수 있습니다.
- 모임에 참여하고 싶은 사람은 게시판의 글을 보고 참여하기 버튼을 눌러 모임에 참여할 수 있습니다.
- 각 게시글에는 현재까지 모집된 인원이 실시간으로 집계되어 보여집니다.

## 팀원 구성

| 김민형 | 김문경 | 신의철 | 이진원 | 조서은 |
| --- | --- | --- | --- | --- |
| https://github.com/MinHyeongK | https://github.com/mun-kyeong | https://github.com/mini-apple | https://github.com/jinwon1234 | https://github.com/macyjoe |

## 1. 개발 환경

- **프론트엔드:** Thymeleaf, tailwind, daisyUI
- **백엔드:** Java Springboot
- **버전 및 이슈관리:** GitHub
- **브랜치 전략:** Github Flow
- **배포 환경:**
- **디자인:** Figma

## 2. 프로젝트 구조

```

│  .gitignore
│  build.gradle
│  db_dev.mv.db
│  db_dev.trace.db
│  Dockerfile
│  gradlew
│  gradlew.bat
│  settings.gradle
│
├─.github
│  └─workflows
│          deploy.yml
│
├─.gradle
│  │  file-system.probe
│  │
│  ├─8.8
│  │  │  gc.properties
│  │  │
│  │  ├─checksums
│  │  │      checksums.lock
│  │  │      md5-checksums.bin
│  │  │      sha1-checksums.bin
│  │  │
│  │  ├─dependencies-accessors
│  │  │      gc.properties
│  │  │
│  │  ├─executionHistory
│  │  │      executionHistory.bin
│  │  │      executionHistory.lock
│  │  │
│  │  ├─expanded
│  │  ├─fileChanges
│  │  │      last-build.bin
│  │  │
│  │  ├─fileHashes
│  │  │      fileHashes.bin
│  │  │      fileHashes.lock
│  │  │      resourceHashesCache.bin
│  │  │
│  │  └─vcsMetadata
│  ├─buildOutputCleanup
│  │      buildOutputCleanup.lock
│  │      cache.properties
│  │      outputFiles.bin
│  │
│  └─vcs-1
│          gc.properties
│
├─.idea
│  │  .gitignore
│  │  .name
│  │  compiler.xml
│  │  gradle.xml
│  │  jarRepositories.xml
│  │  misc.xml
│  │  modules.xml
│  │  uiDesigner.xml
│  │  vcs.xml
│  │  workspace.xml
│  │
│  ├─modules
│  │      team4.main.iml
│  │
│  └─shelf
│      │  Uncommitted_changes_before_Update_at_2024-08-07__3_22__Changes_.xml
│      │  Uncommitted_changes_before_Update_at_2024-08-07__3_22__Changes_1.xml
│      │
│      ├─Uncommitted_changes_before_Update_at_2024-08-07_오후_3_22_[Changes]
│      │      shelved.patch
│      │
│      └─Uncommitted_changes_before_Update_at_2024-08-07_오후_3_22_[Changes]1
│              shelved.patch
│
├─build
│  ├─classes
│  │  └─java
│  │      ├─main
│  │      │  └─com
│  │      │      └─team4
│  │      │          └─team4
│  │      │              │  DataNotFoundException.class
│  │      │              │  MainController.class
│  │      │              │  RecruitmentException.class
│  │      │              │  SecurityConfig.class
│  │      │              │  Team4Application.class
│  │      │              │  WebConfig.class
│  │      │              │
│  │      │              ├─board
│  │      │              │      Board.class
│  │      │              │      BoardController.class
│  │      │              │      BoardForm.class
│  │      │              │      BoardRepository.class
│  │      │              │      BoardService.class
│  │      │              │
│  │      │              ├─participation
│  │      │              │      Participation$ParticipationStatus.class
│  │      │              │      Participation.class
│  │      │              │      ParticipationController.class
│  │      │              │      ParticipationRepository.class
│  │      │              │      ParticipationService.class
│  │      │              │
│  │      │              └─user
│  │      │                      SiteUser.class
│  │      │                      UserController.class
│  │      │                      UserCreateForm.class
│  │      │                      UserModifyForm.class
│  │      │                      UserRepository.class
│  │      │                      UserRole.class
│  │      │                      UserSecurityService.class
│  │      │                      UserService.class
│  │      │
│  │      └─test
│  │          └─com
│  │              └─team4
│  │                  └─team4
│  │                          Team4ApplicationTests.class
│  │
│  ├─generated
│  │  └─sources
│  │      ├─annotationProcessor
│  │      │  └─java
│  │      │      ├─main
│  │      │      └─test
│  │      └─headers
│  │          └─java
│  │              ├─main
│  │              └─test
│  ├─reports
│  │  └─tests
│  │      └─test
│  │          │  index.html
│  │          │
│  │          ├─classes
│  │          │      com.team4.team4.Team4ApplicationTests.html
│  │          │
│  │          ├─css
│  │          │      base-style.css
│  │          │      style.css
│  │          │
│  │          ├─js
│  │          │      report.js
│  │          │
│  │          └─packages
│  │                  com.team4.team4.html
│  │
│  ├─resources
│  │  └─main
│  │      │  application-dev.yml
│  │      │  application-prod.yml
│  │      │  application-secret.yml
│  │      │  application.yml
│  │      │
│  │      └─templates
│  │              board_detail.html
│  │              board_form.html
│  │              form_errors.html
│  │              layout.html
│  │              login_form.html
│  │              main_board.html
│  │              navbarFragment.html
│  │              profile_form.html
│  │              profile_modify.html
│  │              signup_form.html
│  │
│  ├─test-results
│  │  └─test
│  │      │  TEST-com.team4.team4.Team4ApplicationTests.xml
│  │      │
│  │      └─binary
│  │              output.bin
│  │              output.bin.idx
│  │              results.bin
│  │
│  └─tmp
│      ├─compileJava
│      │  │  previous-compilation-data.bin
│      │  │
│      │  └─compileTransaction
│      │      ├─backup-dir
│      │      └─stash-dir
│      │              BoardController.class.uniqueId0
│      │              ParticipationController.class.uniqueId1
│      │              ParticipationService.class.uniqueId2
│      │              UserController.class.uniqueId3
│      │
│      ├─compileTestJava
│      │      previous-compilation-data.bin
│      │
│      └─test
├─gradle
│  └─wrapper
│          gradle-wrapper.jar
│          gradle-wrapper.properties
│
└─src
    ├─main
    │  ├─java
    │  │  └─com
    │  │      └─team4
    │  │          └─team4
    │  │              │  DataNotFoundException.java
    │  │              │  MainController.java
    │  │              │  RecruitmentException.java
    │  │              │  SecurityConfig.java
    │  │              │  Team4Application.java
    │  │              │  WebConfig.java
    │  │              │
    │  │              ├─board
    │  │              │      Board.java
    │  │              │      BoardController.java
    │  │              │      BoardForm.java
    │  │              │      BoardRepository.java
    │  │              │      BoardService.java
    │  │              │
    │  │              ├─participation
    │  │              │      Participation.java
    │  │              │      ParticipationController.java
    │  │              │      ParticipationRepository.java
    │  │              │      ParticipationService.java
    │  │              │
    │  │              └─user
    │  │                      SiteUser.java
    │  │                      UserController.java
    │  │                      UserCreateForm.java
    │  │                      UserModifyForm.java
    │  │                      UserRepository.java
    │  │                      UserRole.java
    │  │                      UserSecurityService.java
    │  │                      UserService.java
    │  │
    │  └─resources
    │      │  application-dev.yml
    │      │  application-prod.yml
    │      │  application-secret.yml
    │      │  application.yml
    │      │
    │      └─templates
    │              board_detail.html
    │              board_form.html
    │              form_errors.html
    │              layout.html
    │              login_form.html
    │              main_board.html
    │              navbarFragment.html
    │              profile_form.html
    │              profile_modify.html
    │              signup_form.html
    │
    └─test
        └─java
            └─com
                    └─team4
                            Team4ApplicationTests.java

```

## 3. 역할 분담

🦊김민형 - 백엔드, 인프라

🐼김문경- 백엔드, 인프라

🐯신의철 - 백엔드, 프론트엔드

🦝이진원 - 백엔드, 프론트엔드

🦁조서은 - 백엔드, 프론트엔드

 

## 4. 개발 기간 및 작업 관리

- **전체 개발 기간:** 2024-08-05 ~ 2024-08-08
- **작업 관리:** GitHub Issues를 통해 진행 상황을 공유하였고 대면으로 프로젝트를 진행하였기 때문에 소통이 원활했습니다. GitHub Flow 전략으로 협업했습니다.

## 5. 페이지별 기능

![image](https://github.com/user-attachments/assets/c33e0795-199a-488d-be84-44eb986be781)
**[서비스 접속화면(게시판 보드)]** 

서비스를 접속하게 되면 위 사진과 같이 모집중인 소모임 게시글들이 최신순으로 정렬되어있습니다.

![image](https://github.com/user-attachments/assets/f8606bf1-da5c-4ff2-8e1c-2e01128a41c5)

**[로그인 화면]**

사용자 ID와 비밀번호를 입력하고 ‘로그인’ 버튼을 누르면 로그인이 가능하고 ‘회원가입’ 버튼을 누르면 회원가입 창으로 넘어갑니다.

![image](https://github.com/user-attachments/assets/162d2f2c-b664-4960-b22a-33875e2c2e48)

**[회원가입 화면]**

회원가입을 위해 사용자ID, 비밀번호, 이메일, 연락처, 자기소개, SNS계정을 입력받습니다.

![image](https://github.com/user-attachments/assets/182a9dea-1a09-4f67-b012-fcb33885f9dd)


**[게시글 작성화면]**

로그인 후 소모임 생성하기 버튼을 누르면 소모임 모집글을 작성할 수 있습니다.(로그인 되지 않은 상태라면 로그인 창으로 넘어갑니다.)

게시글 이름/설명글,  소모임 시작/종료 날짜/진행 지역,  전체 필요 인원수, 추천 나이대 입력가능합니다. 

![image](https://github.com/user-attachments/assets/e0fd4398-54e1-498c-bba8-f2336467087a)

**[게시판 상세화면-참여자]**

로그인 후 소모임 모집글에 접속해서 ‘나도 참여하기’ 버튼을 누르면 참여 신청이 됩니다. 중복 신청은 불가능하며 게시글 작성자가 수락 또는 거절 가능합니다.

![image](https://github.com/user-attachments/assets/3fe57a71-41d1-4bb5-901d-05f0015fff24)


**[게시판 상세화면-게시글 작성자]**

소모임 모집글을 작성한 게시글 작성자 본인은 게시글 수정 혹은 삭제가 가능합니다. 또한,  참여 신청에 대한 수락 혹은 거절이 가능합니다.  현재 모집 인원 수가 최대 모집 인원 수 이상이면 수락이 불가능합니다. 

![image](https://github.com/user-attachments/assets/f33b604a-356b-42ec-90e8-1c131fab3aec)


**[프로필 화면]**

프로필 화면에 접속하면 참여신청이 온 게시글에 대한 알람이 옵니다. ‘게시글 이동하기’ 버튼을 누르면 참여신청이 들어온 게시글로 이동합니다.

![image](https://github.com/user-attachments/assets/3ef57071-96c6-41bc-91d9-e8571c0cc08c)

**[프로필 수정 화면]**

프로필 화면에서 ‘프로필 수정’ 버튼을 누르면 프로필 수정화면으로 넘어가고 연락처, 자기소개, SNS계정에 대한 변경이 가능합니다.

## 6. 트러블 슈팅

**-중복 신청 이슈-**

이미 참여 신청이 완료된 사용자가 ‘나도 참여하기’ 버튼을 또 누르면 중복신청이 되는 문제가 발생하였다.

```java
package com.team4.team4.participation;

import com.team4.team4.user.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipationRepository extends JpaRepository<Participation, Long> {
  List<Participation> findByBoard_Id(Long boardId); //특정 Board 게시글에 대한 모든 참여 신청을 반환
  List<Participation> findByParticipant_Id(Long participantId); //특정 사용자(SiteUser)가 참여한 모든 게시글 참여 신청을 반환
  boolean existsByBoardIdAndParticipant(Long boardId, SiteUser participant); //이미 신청한상태이면 True를 반환
}
```

Participation Repository에 boolean existsByBoardIdAndParticipant(Long boardId, SiteUser participant)를 생성했다.

```java
  public boolean isAlreadyParticipated(Long boardId, SiteUser participant) {
    // 이미 신청한 여부를 체크하는 로직
    return participationRepository.existsByBoardIdAndParticipant(boardId, participant);
  }
```

ParticipationService에 이미 신청한 사용자라면 True를 반환하는 기능을 구현 

```java
 @PostMapping("/create/{boardId}")
    public String createParticipation(Model model, @PathVariable("boardId") Long boardId, Principal principal) {
        if (principal == null) {
            return "redirect:/user/login";
        }
        SiteUser participant = userService.getUser(principal.getName());
        if (participationService.isAlreadyParticipated(boardId,participant)) {
            model.addAttribute("error", "이미 이 게시글에 신청하셨습니다.");
            // 게시글 상세 페이지로 리다이렉트
            return String.format("redirect:/board/detail/%s", boardId);
        }
        participationService.createParticipation(boardId, participant);
        return String.format("redirect:/board/detail/%s", boardId);
    }
```

마지막으로 ParticipationController에서 isAlreadyParticipated가 True를 반환하면 게시글 상세페이지로 리다이렉트 하게
