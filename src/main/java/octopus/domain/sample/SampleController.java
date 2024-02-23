package octopus.domain.sample;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import octopus.base.common.dto.MessageDto;
import octopus.domain.post.PostRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@RequiredArgsConstructor
public class SampleController {
    private String showMessageAndRedirect( final MessageDto params, Model model ) {
        model.addAttribute( "params", params );
        return "common/messageRedirect";
    }

    // 신규 게시글 생성
    @PostMapping( "/posts/sample_save.do" )
    public String saveSample( final PostRequest params, Model model ) {
        MessageDto message = new MessageDto( "저장되었습니다.", "/sample/sample.do", RequestMethod.GET, null );
        return showMessageAndRedirect( message, model );
    }
}
