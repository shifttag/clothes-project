package com.a1.a1.service.implement;

import com.a1.a1.common.constant.ResponseMessage;
import com.a1.a1.dto.request.ask.AskPatchRequestDto;
import com.a1.a1.dto.request.ask.AskPostRequestDto;
import com.a1.a1.dto.response.ResponseDto;
import com.a1.a1.dto.response.ask.*;
import com.a1.a1.entity.AskEntity;
import com.a1.a1.entity.UserEntity;
import com.a1.a1.repository.AskRepository;
import com.a1.a1.repository.UserRepository;
import com.a1.a1.service.AskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AskServiceImpl implements AskService {

    private final AskRepository askRepository;
    private final UserRepository userRepository;

    public ResponseDto<AskPostResponseDto> postAsk(AskPostRequestDto dto, Long userId
    ){
        AskPostResponseDto data = null;
        userRepository.findById(String.valueOf(userId)).orElseThrow(() -> new Error(ResponseMessage.NOT_EXIST_USER));
        int askSort = dto.getAskSort();
        String askTitle = dto.getAskTitle();
        String askContent = dto.getAskContent();
        LocalDateTime now = LocalDateTime.now();

        try {
            AskEntity askEntity = AskEntity.builder()
                    .askTitle(askTitle)
                    .askContent(askContent)
                    .askSort(askSort)
                    .askDatetime(now)
                    .userId(userId)
                    .build();
            askRepository.save(askEntity);
            data = new AskPostResponseDto(askEntity,userId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS,data);

    }


    // 뮨의 전채 조회
    @Override
    public ResponseDto<List<AskGetListResponseDto>> getAskAllByAskId(Long userId) {
//        List<AskGetListResponseDto> data = null;
//        try {
//            Optional<List<AskEntity>> optionalAskEntities = askRepository.getAskAllByAskId(userId);
//            if(optionalAskEntities.isEmpty()){
//                return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
//            }
//            List<AskEntity> askEntities = optionalAskEntities.get();
//            data = askEntities.stream().map(AskGetListResponseDto::new)
//                    .collect(Collectors.toList());
//        } catch (Exception e){
//            e.printStackTrace();
//            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
//        }
//        return ResponseDto.setSuccess(ResponseMessage.SUCCESS,data);
        return null;
    }



    public ResponseDto<AskGetFindResponseDto> findByUserIdAndAskDatetimeGreaterThanEqualAndAskSortAndAskStatusOrderByAskDatetimeDesc(Long userId, int askStatus, int months, int askSort) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = Date.from(Instant.now().minus(months * 30, ChronoUnit.DAYS));
        String askDateTime = simpleDateFormat.format(date);

        AskGetFindResponseDto data = null;

        try {

            Optional<AskEntity> optionalAskEntity = askRepository.findByUserIdAndAskDatetimeGreaterThanEqualAndAskSortAndAskStatusOrderByAskDatetimeDesc(userId, LocalDateTime.parse(String.valueOf(askStatus)),months,askSort);
            if (optionalAskEntity.isEmpty()) {
                return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
            }
            AskEntity askEntity = optionalAskEntity.get();
            data = new AskGetFindResponseDto(askEntity,userId);
        } catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }
//
    // 문의 문의 아이디로 조회
    public ResponseDto<AskGetAskIdResponseDto> getAskId(int askId
    ) {
        AskGetAskIdResponseDto data = null;
        try {
            Optional<AskEntity> optionalAskEntity = askRepository.findById(askId);
            if (optionalAskEntity.isEmpty()) {
                return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
            }
            AskEntity askEntity = optionalAskEntity.get();
            data = new AskGetAskIdResponseDto(askEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
    }
//
//    @Override
//    public ResponseDto<AskPatchResponseDto> patchAsk(AskPatchRequestDto dto) {
//        AskPatchResponseDto data = null;
//        int askId = dto.getAskId();
//
//        try {
//            AskEntity askEntity = (AskEntity) askRepository.findByAskId(askId);
//            if (askEntity == null) return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
//            askEntity.patch(dto);
//            askRepository.save(askEntity);
//
//            data = new AskPatchResponseDto(askEntity);
//        } catch (Exception e){
//            e.printStackTrace();
//            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
//        }
//        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, data);
//    }
//
    // 문의 삭제
    @Override
    @Transactional
    public ResponseDto<Boolean> deleteByAskId(int askId) {
        try {
            askRepository.deleteByAskId( askId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.setFailed(ResponseMessage.DATABASE_ERROR);
        }
        return ResponseDto.setSuccess(ResponseMessage.SUCCESS, true);
    }

}