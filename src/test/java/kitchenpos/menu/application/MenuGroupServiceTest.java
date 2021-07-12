package kitchenpos.menu.application;

import kitchenpos.menu.domain.entity.MenuGroup;
import kitchenpos.menu.domain.entity.MenuGroupRepository;
import kitchenpos.menu.dto.MenuGroupRequest;
import kitchenpos.menu.dto.MenuGroupResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MenuGroupServiceTest {
    @Mock
    MenuGroupRepository menuGroupRepository;

    @InjectMocks
    MenuGroupService menuGroupService;

    MenuGroup 메뉴그룹_한마리메뉴;
    MenuGroup 메뉴그룹_두마리메뉴;

    MenuGroupRequest 메뉴그룹_한마리메뉴_리퀘스트;
    MenuGroupRequest 메뉴그룹_두마리메뉴_리퀘스트;

    @BeforeEach
    void setUp() {
        메뉴그룹_한마리메뉴 = new MenuGroup("한마리메뉴");
        메뉴그룹_두마리메뉴 = new MenuGroup("두마리메뉴");

        메뉴그룹_한마리메뉴_리퀘스트 = new MenuGroupRequest("한마리메뉴");
        메뉴그룹_두마리메뉴_리퀘스트 = new MenuGroupRequest("두마리메뉴");
    }

    @Test
    @DisplayName("메뉴그룹을 생성한다.")
    void create() {
        //given
        when(menuGroupRepository.save(any())).thenReturn(메뉴그룹_한마리메뉴);

        //when
        MenuGroupResponse createdMenuGroup = menuGroupService.create(메뉴그룹_한마리메뉴_리퀘스트);

        //then
        assertThat(createdMenuGroup.getName()).isEqualTo(메뉴그룹_한마리메뉴.getName());
    }


    @Test
    @DisplayName("전체 메뉴그룹을 조회한다.")
    void list() {
        //given
        when(menuGroupRepository.findAll()).thenReturn(Arrays.asList(메뉴그룹_한마리메뉴, 메뉴그룹_두마리메뉴));

        //when
        List<MenuGroupResponse> foundMenuGroups = menuGroupService.list();

        //then
        assertThat(foundMenuGroups.stream().map(MenuGroupResponse::getName).collect(Collectors.toList()))
                .containsExactly(메뉴그룹_한마리메뉴.getName(), 메뉴그룹_두마리메뉴.getName());
    }
}