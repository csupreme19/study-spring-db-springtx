package hello.springtx.propagation;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    LogRepository logRepository;

    @Test
    public void outerTxOff_Success() {
        // given
        String username = "outerTxOff_Success";

        // when
        memberService.joinV1(username);

        // then
        assertThat(memberRepository.find(username).isPresent()).isTrue();
        assertThat(logRepository.find(username).isPresent()).isTrue();
    }

}