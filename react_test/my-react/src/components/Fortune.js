import React, { Component } from 'react';

class Fortune extends Component {
    render() {
        // 부모 conponent가 전달한 property는 자식 component에서
        // this.props로 참조할 수 있다
        return (
            <>
                <h3>운세</h3>
                <p>오늘의 운세 : <strong>{this.props.data}</strong></p>
            </>
        );
    }
}

export default Fortune;